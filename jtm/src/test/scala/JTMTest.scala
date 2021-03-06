import com.mass.jtm.optim.JTM
import com.mass.jtm.tree.TreeUtil
import com.mass.sparkdl.utils.Engine
import org.apache.log4j.{Level, Logger}
import org.scalatest.flatspec.AnyFlatSpec

class JTMTest extends AnyFlatSpec {
  Logger.getLogger("com.mass").setLevel(Level.INFO)

  val numThread = 8
  Engine.setNodeAndCore(1, numThread)
  val prefix = s"${System.getProperty("user.dir")}/data/"
  val jtm = JTM(
    modelName = "DIN",
    gap = 1,
    seqLen = 10,
    hierarchical = false,
    minLevel = 0,
    numThreads = numThread
  )
  jtm.load(
    prefix + "train_data.csv",
    prefix + "tree_pb_data.txt",
    prefix + "model.bin"
  )
  val projection = jtm.optimize()
  val treeMeta = TreeUtil.getTreeMeta(jtm)
  TreeUtil.writeTree(jtm, projection, prefix + "jtm_tree_data.txt")

  "Final projection" should "have correct leaf size" in {
    assert(projection.size == treeMeta.leafNum)
  }

  "Final projection" should "have sufficient item ids" in {
    assert(projection.size == treeMeta.itemIds.length)
    assert(projection.keys.forall(treeMeta.itemIds.contains))
  }

  "Final projection" should "have correct range" in {
    val minLeafCode = math.pow(2, treeMeta.maxLevel).toInt - 1
    val maxLeafCode = minLeafCode * 2
    assert(projection.values.min >= minLeafCode)
    assert(projection.values.max <= maxLeafCode)
  }
}
