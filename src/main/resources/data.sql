insert into order_management.order_table(order_id, order_date, total_price) values(101,sysdate(),2000);

insert into order_management.product_table(product_id, price, product_name) values(1001,1000,'Shirt');
insert into order_management.product_table(product_id, price, product_name) values(1002,1000,'Kurta');

insert into order_management.order_product(fk_order, fk_product) values(101,1001);
insert into order_management.order_product(fk_order, fk_product) values(101,1002);