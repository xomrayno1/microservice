cd ..
cd DiscoveryServer
mvn clean install  -Dmaven.test.skip=true

cd ..
cd CloudGateway
mvn clean install  -Dmaven.test.skip=true

cd ..
cd ConfigServer
mvn clean install  -Dmaven.test.skip=true

cd ..
cd core
mvn clean install -Dmaven.test.skip=true

cd ..
cd StockService
mvn clean install  -Dmaven.test.skip=true

cd ..
cd SaleService
mvn clean install  -Dmaven.test.skip=true
cd ..