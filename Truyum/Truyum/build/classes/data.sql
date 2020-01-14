use truyum;

/*View Menu Item List admin */

INSERT INTO `truyum`.`menu_item` (`me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`) VALUES ('Sandwich', '99', '1', '2020-09-02', 'Main Course', '1');
INSERT INTO `truyum`.`menu_item` (`me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`) VALUES ('Burger', '129', '1', '2020-03-01', 'Main Course', '0');
INSERT INTO `truyum`.`menu_item` (`me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`) VALUES ('pizza', '149', '1', '2019-19-02', 'Main Course', '0');
INSERT INTO `truyum`.`menu_item` (`me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`) VALUES ('French Fries', '157', '0', '2019-05-04', 'Starter', '0');
INSERT INTO `truyum`.`menu_item` (`me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`) VALUES ('Chocolate Brownie', '32', '0', '2020-04-04', 'Starter', '0');

INSERT INTO `truyum`.`user` (`us_name`) VALUES ('vijay');
INSERT INTO `truyum`.`user` (`us_name`) VALUES ('Surya');

select * from truyum.menu_item;


/*View Menu Item List Customer */
select *from 
truyum.menu_item
where menu_item.me_date_of_launch>=CURDATE() AND me_active='1'
;

/*Edit Menu Item */

select * FROM truyum.menu_item
where me_id=5;

update truyum.menu_item
set
me_name ='Sand',
me_date_of_launch='2018-03-03',
me_category='main',
me_free_delivery  ='NO',
me_price =111
where me_id=1;


/*Add to Cart */

INSERT INTO `truyum`.`cart` (`ct_us_id`, `ct_pr_id`) VALUES ('1', '1');
INSERT INTO `truyum`.`cart` (`ct_us_id`, `ct_pr_id`) VALUES ('1', '2');
INSERT INTO `truyum`.`cart` (`ct_us_id`, `ct_pr_id`) VALUES ('1', '3');


/* View Cart  */

select truyum.menu_item.me_name,menu_item.me_free_delivery,menu_item.me_price from cart
inner join menu_item on menu_item.me_id=cart.ct_pr_id
inner join user on user.us_id=cart.ct_us_id
where user.us_id=1;

/* price */
select truyum.user.us_id,sum(menu_item.me_price) as me_total from cart
inner join menu_item on menu_item.me_id=cart.ct_pr_id
inner join user on user.us_id=cart.ct_us_id
where user.us_id=1;

/*Remove Item from Cart  */
delete from truyum.cart where ct_us_id=1 and ct_pr_id=1;