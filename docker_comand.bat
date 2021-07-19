docker image build -t aws .

docker container run -d --name aws-shop -p 8085:8085 aws

docker container ls -as

docker stop aws-shop



