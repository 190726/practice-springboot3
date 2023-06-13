insert into product(id, product_number, type, selling_status, name, price)
values (product_seq.nextval,'001', 'HANDMADE', 'SELLING', '아메리카노', 4000),
       (product_seq.nextval, '002', 'HANDMADE', 'HOLD', '카페라떼', 4500),
       (product_seq.nextval,'003', 'BAKERY', 'STOP_SELLING', '크루아상', 3500);