insert into authors (id , first_name, last_name)
values (1,'Gary', 'Romero'),
(2,'David', 'Smith'),
(3,'Angela', 'Marshall');

insert into categorys (id, category_name)
values (1,'information'),
(2,'technology'),
(3,'man'),
(4,'nature');

insert into articles (id, article_name, summary, content, author_id, category_id,publication_date)
values (1, 'Ideological considerations of a higher order',
'Ideological considerations of a higher order, as well as the scope and place of personnel training, provide a wide range of (specialists) participation in the formation of new proposals. Everyday practice shows that the implementation of the planned targets largely determines the creation of a development model.',
 'Ideological considerations of a higher order, as well as the strengthening and development of the structure, play an important role in the formation of significant financial and administrative conditions. Comrades constant information and propaganda support of our activities allows us to perform important tasks in developing a development model.
 Thus, the implementation of the planned targets makes it possible to evaluate the value of new proposals. On the other hand, the strengthening and development of the structure ensures participation in the formation of systems of mass participation. Ideological considerations of a higher order, as well as the scope and place of personnel training, provide a wide range of (specialists) participation in the formation of new proposals.
On the other hand, the strengthening and development of the structure ensures participation in the formation of systems of mass participation. Ideological considerations of a higher order, as well as the scope and place of personnel training, provide a wide range of (specialists) participation in the formation of new proposals. Everyday practice shows that the implementation of the planned targets largely determines the creation of a development model.',
1,4,'2018-10-22'),
(2, 'New model of organizational activity', 'Diverse and rich experience consultation with a wide asset provides a wide range. Thus, the new model of organizational activity contributes to the preparation and implementation of systems of mass participation. ',
 'Thus, the new model of organizational activity contributes to the preparation  and implementation of systems of mass participation. The significance of these problems is so obvious that   consultation with a wide asset plays an important role in the formation of new proposals. On the other hand,   the framework and place of staff training contributes to the preparation and implementation of the development   model.
The significance of these problems is so obvious that consultation with a wide asset plays an important role in the formation of new proposals. Diverse and rich experience consultation with a wide asset provides a wide range. Thus, the new model of organizational activity contributes to the preparation and implementation of systems of mass participation.',
2,3, '2022-03-14');

insert into tags (id, tag_name, article_id)
values (1, 'theatre', 1),
(2, 'cinema', 1),
(3, 'history',2),
(4, 'higher forms', 2);
