use movie_cruiser;

/*View Movie admin */

INSERT INTO `movie_cruiser`.`movies` (`mo_title`, `mo_gross`, `mo_active`, `mo_genre`, `mo_date_of_launch`, `mo_has_teaser`) VALUES ('Avatar', '2787965087', '1', 'Science Fiction', '2020-02-02', '1');
INSERT INTO `movie_cruiser`.`movies` (`mo_title`, `mo_gross`, `mo_active`, `mo_genre`, `mo_date_of_launch`, `mo_has_teaser`) VALUES ('The Avengers', '1518812988', '1', 'Super Hero', '2020-02-02', '0');
INSERT INTO `movie_cruiser`.`movies` (`mo_title`, `mo_gross`, `mo_active`, `mo_genre`, `mo_date_of_launch`, `mo_has_teaser`) VALUES ('Titanic', '2187463944', '1', 'Romance', '2020-02-02', '0');
INSERT INTO `movie_cruiser`.`movies` (`mo_title`, `mo_gross`, `mo_active`, `mo_genre`,`mo_date_of_launch`, `mo_has_teaser`) VALUES ('Jurassic World', '1671713208', '0', 'Romance','2020-02-02', '1');
INSERT INTO `movie_cruiser`.`movies` (`mo_title`, `mo_gross`, `mo_active`, `mo_genre`,`mo_date_of_launch`, `mo_has_teaser`) VALUES ('Avengers:End Game', '2750760348', '0','Romance', '2020-02-02', '1');

INSERT INTO `movie_cruiser`.`user` (`us_name`) VALUES ( 'urya');
INSERT INTO `movie_cruiser`.`user` (`us_name`) VALUES ('ijay');

select * from movie_cruiser.movies;


/*View Movie Customer */

use movie_cruiser;

select mo_title,mo_gross,mo_active,mo_genre,mo_date_of_launch,mo_has_teaser from movies
where movies.mo_date_of_launch>=CURDATE() AND mo_active='1'
;

/*Edit Movies */

select * from movie_cruiser.movies
where mo_id=1;

update movie_cruiser.movies
set
mo_title ='Avatar',
mo_date_of_launch='2018-03-03',
mo_genre='Science Fiction',
mo_has_teaser ='0',
mo_gross=11132423
where mo_id=1;


/*Add to Favorites*/

INSERT INTO `movie_cruiser`.`favorite` (`fv_us_id`, `fv_mo_id`) VALUES ('1', '1');
INSERT INTO `movie_cruiser`.`favorite` (`fv_us_id`, `fv_mo_id`) VALUES ('1', '2');
INSERT INTO `movie_cruiser`.`favorite` (`fv_us_id`, `fv_mo_id`) VALUES ('1', '3');



/* View Favorites */

use movie_cruiser;

select movie_cruiser.movies.mo_id,movies.mo_title,movies.mo_gross,movies.mo_active,movies.mo_genre,movies.mo_date_of_launch,movies.mo_has_teaser from favorite
inner join movies on movies.mo_id=favorite.fv_mo_id
inner join user on user.us_id=favorite.fv_us_id
where user.us_id=1;

/* Number of Favorites */

use movie_cruiser;

select count(movies.mo_id) as numberoffavorites from favorite
inner join movies on movies.mo_id=favorite.fv_mo_id
inner join user on user.us_id=favorite.fv_us_id
where user.us_id=1;




/*Remove Movie from Favorite */


use movie_cruiser;

delete from movie_cruiser.favorite where fv_us_id=1 and fv_mo_id=1;






