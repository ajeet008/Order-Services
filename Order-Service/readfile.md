1.clone the project

git clone https://github.com/ajeet008/Order-Services.git

2. import the project in eclipse 

3. set the build path using jdk 1.8

4.and mvn clean and install

5.using the DB H2 Database 

6.After running the project then this url is call http://localhost:8080/h2/

after connect db then create one table name as orders

then call api url in mention 
1.API Details:
for Summary:
http://localhost:8080/api/summary

for Cancel the Order:
http://localhost:8080/api/cancelOrder/1

1 as OrderId .

for Add the order

http://localhost:8080/api/addOrder

body Parameter as 

 {
  "price":308,
  "quantity":1.5,
  "orderType":"SELL",
   "userId":"uesr4"
   
  }
