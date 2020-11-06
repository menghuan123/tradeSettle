#!/bin/sh
echo "ready to generate a project......"
read -p "please input artifactId(demo):" artifactId

read -p "please input package(com.tencent.sr.rmall.demo):" package

read -p "input version(1.0.0-SNAPSHOT):" version


echo $artifactId
echo package
echo version

echo "start generate a project,just Enter......"

mvn archetype:generate -DgroupId=com.tencent.sr.rmall -DartifactId=$artifactId -Dversion=$version -Dpackage=$package -DarchetypeArtifactId=spring-boot-scaffold-archetype -DarchetypeGroupId=com.tencent.sr.rmall -DarchetypeVersion=0.0.2-SNAPSHOT  -DarchetypeCatalog=internal



echo "create success!!"