# Spark-Retrieval

This repository contains an implementation of **TDM**, a tree-based deep learning algorithm for retrieval problem in recommender system. 

Due to the common situation that large-scale recommender systems usually contain a large number of items, complex deep learning models are often impractical to use. Since it requires traversing all the items to compute scores respectively, which leads to linear complexity w.r.t. the whole item set. To alleviate this issue, nowadays most real-world recommender systems tend to convert it into an approximate similarity-searching(computing) problem, but the downside is the model expressiveness is limited.

Thus the most intriguing feature of TDM is providing logarithmic complexity (O(n) => O(log n)) w.r.t. the whole item set for model serving, where arbitrary deep models can be used in it. By introducing a hierarchical tree structure, TDM greatly reduces the whole computation. Please refer to the original [TDM paper](https://arxiv.org/abs/1801.02294) for more details.

The implementation is based upon Apache Spark for distributed training. Training a deep learning model directly on top of Spark cluster can let users easily build an end-to-end pipeline by leveraging the powerful data processing ability of Spark. In order to accelerate model training, multi-threading is also extensively used in this implementation.

Currently the repository contains three modules:

+ **sparkdl** is responsible for general deep learning model definition.
+ **tdm** is responsible for TDM tree construction and learning.
+ **examples** contains some runnable tasks.

More advanced retrieval algorithms published in recent years, such as [JTM](https://arxiv.org/abs/1902.07565), [OTM](https://arxiv.org/abs/2006.15408) and [Deep-Retrieval](https://arxiv.org/abs/2007.07203), are on the todo list.

## Requirements

+ JDK 1.8
+ Spark 2.4 with Scala 2.12. Note that using scala 2.11 will not work.
+ Maven \>= 3.3

## Data

An example data is included in `data` folder, which comes from `movielens-1m` dataset.

## Usage

First clone the repository: 

```shell
$ git clone https://github.com/massquantity/Spark-Retrieval.git	
```

For quick running, you can directly import it into an IDE, i.e. `IntelliJ IDEA`. We can also use Maven to package it into a jar file:

```shell
$ cd Spark-Retrieval
$ mvn clean package -DskipTests
```

All of the modules will generate jar files, but we will only use the jar file in `examples` module.

`Spark-Retrieval` can run locally or on a cluster. To run locally, you need to install Java 8 or Scala 2.12 and set up the parameters in `Spark-Retrieval/configs/tdm_local.conf` file. To run on a cluster, you need a Hadoop and Spark cluster and set up the parameters  in `Spark-Retrieval/configs/tdm_dist.conf` file.

Then we can begin to train the TDM model. The various generated files during these steps will be located in the paths specified in `conf` files.

The first step is Initializing tree:

```shell
# local mode, use either java or scala.
$ java -cp examples-1.0-jar-with-dependencies.jar \
    com.mass.retrieval.tdm.InitializeTree \
    --tdmConfFile Spark-Retrieval/configs/tdm_local.conf
    
$ scala -cp examples-1.0-SNAPSHOT-jar-with-dependencies.jar \
    com.mass.retrieval.tdm.InitializeTree \
    --tdmConfFile Spark-Retrieval/configs/tdm_local.conf
```

```shell
# distributed mode
$ spark-submit --class com.mass.retrieval.tdm.InitializeTree \
    --master spark://xxx.xxx.xxx.xxx:7077
    examples-1.0-jar-with-dependencies.jar \
    --tdmConfFile Spark-Retrieval/configs/tdm_dist.conf
```

The second step is training the deep model:

```shell
# local mode, use either java or scala. try setting -Xmxn or -J-Xmxn when encountering java.lang.OutOfMemoryError
$ java -cp examples-1.0-jar-with-dependencies.jar \
    com.mass.retrieval.tdm.TrainLocal \
    --tdmConfFile Spark-Retrieval/configs/tdm_local.conf
    
$ scala -cp examples-1.0-jar-with-dependencies.jar \
    com.mass.retrieval.tdm.TrainLocal \
    --tdmConfFile Spark-Retrieval/configs/tdm_local.conf
```

```shell
# ditributed mode, master can be standalone or yarn
$ spark-submit --class com.mass.retrieval.tdm.TrainDist \
    --master spark://xxx.xxx.xxx.xxx:7077
    examples-1.0-jar-with-dependencies.jar \
    --tdmConfFile Spark-Retrieval/configs/tdm_dist.conf
```

The third step is clustering tree:

```shell
# local mode, use either java or scala.
$ java -cp examples-1.0-jar-with-dependencies.jar \
    com.mass.retrieval.tdm.ClusterTree \
    --tdmConfFile Spark-Retrieval/configs/tdm_local.conf
    
$ scala -cp examples-1.0-jar-with-dependencies.jar \
    com.mass.retrieval.tdm.ClusterTree \
    --tdmConfFile Spark-Retrieval/configs/tdm_local.conf
```

```shell
# ditributed mode
$ spark-submit --class com.mass.retrieval.tdm.ClusterTree \
    --master spark://xxx.xxx.xxx.xxx:7077
    examples-1.0-jar-with-dependencies.jar \
    --tdmConfFile Spark-Retrieval/configs/tdm_dist.conf
```

Finally the fourth step is retraining the deep model, and this is the same as the second step.



## Configuration

The descriptions of parameters in `conf` file are listed in Configuration doc.



