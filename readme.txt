springcloud

关于一致性CAP， C是Consistency一致性, A是Availbility可用性， P是Partition tolerance分区容错（分布式）
zookeeper 是CP， 保证一致性
Consul是CP
eureka 是AP, 保证可用性，不保证一致性
nacos 模式可以切换，CP或者AP， nacos是CP的时候是以raft协议保证nacos集群的一致性， zk的cp是zab协议

springCloud适合AP， 哪怕服务挂掉至少调用方可以收到响应
K8s和DNS服务适合CP，需要强一致性


关于nacos集群
nacos内置一个数据库， 集群的时候，需要配置mysql数据库（目前只支持mysql）
还需要nginx转发请求到nacos集群下的每个nacos实例
具体看linux系统中的/usr/local/nacos-cluster（已经搭建成功，mysql也在Linux中，）
注意nacos-cluster文件下的startall.sh不能直接运行，直接运行会生成4个nacos实例，集群会失败，
而需要自己手动一个一个执行，不知道为什么坑死了
