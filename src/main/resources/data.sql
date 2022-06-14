drop sequence if exists hibernate_sequence;
create sequence hibernate_sequence start with 100 increment by 1;

insert into curso (id, name, acronym, created_at)
values (1, 'Primero Desarrollo Aplicaciones Multiplataforma','1DAM',NOW());
insert into curso (id, name, acronym, created_at)
values (2, 'Segundo Desarrollo Aplicaciones Multiplataforma','2DAM',NOW());

insert into modulo (id, name,acronym,created_at,curso_id)
values (1,'Sistemas informáticos','SI',NOW(),1);
insert into modulo (id, name,acronym,created_at,curso_id)
values (2,'Bases de Datos','BDD',NOW(),1);
insert into modulo (id, name,acronym,created_at,curso_id)
values (3,'Programación','PRG',NOW(),1);
insert into modulo (id, name,acronym,created_at,curso_id)
values (4,'Lenguajes de marcas y sistemas de gestión de información','LMSGI',NOW(),1);
insert into modulo (id, name,acronym,created_at,curso_id)
values (5,'Entornos de desarrollo','EDD',NOW(),1);
insert into modulo (id, name,acronym,created_at,curso_id)
values (6,'Formación y orientación laboral','FOL',NOW(),1);

insert into modulo (id, name,acronym,created_at,curso_id)
values (7,'Acceso a datos','AAD',NOW(),2);
insert into modulo (id, name,acronym,created_at,curso_id)
values (8,'Desarrollo de interfaces','DDI',NOW(),2);
insert into modulo (id, name,acronym,created_at,curso_id)
values (9,'Programación multimedia y dispositivos móviles','PMDM',NOW(),2);
insert into modulo (id, name,acronym,created_at,curso_id)
values (10,'Programación de servicios y procesos','PSP',NOW(),2);
insert into modulo (id, name,acronym,created_at,curso_id)
values (11,'Sistemas de gestión empresarial','SGE',NOW(),2);
insert into modulo (id, name,acronym,created_at,curso_id)
values (12,'Sistemas de gestión empresarial','SGE',NOW(),2);
insert into modulo (id, name,acronym,created_at,curso_id)
values (13,'Empresa e iniciativa emprendedora','EIE',NOW(),2);
insert into modulo (id, name,acronym,created_at,curso_id)
values (14,'Formación en centros de trabajo','FCT',NOW(),2);
insert into modulo (id, name,acronym,created_at,curso_id)
values (15,'Proyecto de desarrollo de aplicaciones multiplataforma','PDAM',NOW(),2);

insert into alumno (id, name, email,created_at,updated_at,avatar)
values (1, 'Loralie Bouts', 'lbouts0@jiathis.com',NOW(),NOW(),'https://i.pravatar.cc/300?img=1');
insert into alumno (id, name, email,created_at,updated_at,avatar)
values (2, 'Celinka Slisby', 'cslisby1@slate.com',NOW(),NOW(),'https://i.pravatar.cc/300?img=2');
insert into alumno (id, name, email,created_at,updated_at,avatar)
values (3, 'Parnell New', 'pnew2@creativecommons.org',NOW(),NOW(),'https://i.pravatar.cc/300?img=3');
insert into alumno (id, name, email,created_at,updated_at,avatar)
values (4, 'Sergei Erridge', 'serridge3@shareasale.com',NOW(),NOW(),'https://i.pravatar.cc/300?img=4');
insert into alumno (id, name, email,created_at,updated_at,avatar)
values (5, 'Kit Berrey', 'kberrey4@ebay.co.uk',NOW(),NOW(),'https://i.pravatar.cc/300?img=5');
insert into alumno (id, name, email,created_at,updated_at,avatar)
values (6, 'Trent Ditch', 'tditch5@storify.com',NOW(),NOW(),'https://i.pravatar.cc/300?img=6');
insert into alumno (id, name, email,created_at,updated_at,avatar)
values (7, 'Billie Villa', 'bvilla6@cpanel.net',NOW(),NOW(),'https://i.pravatar.cc/300?img=7');
insert into alumno (id, name, email,created_at,updated_at,avatar)
values (8, 'Lorry Blagdon', 'lblagdon7@imdb.com',NOW(),NOW(),'https://i.pravatar.cc/300?img=8');
insert into alumno (id, name, email,created_at,updated_at,avatar)
values (9, 'Jared Breston', 'jbreston8@infoseek.co.jp',NOW(),NOW(),'https://i.pravatar.cc/300?img=9');
insert into alumno (id, name, email,created_at,updated_at,avatar)
values (10, 'Rozanne Beek', 'rbeek9@goo.ne.jp',NOW(),NOW(),'https://i.pravatar.cc/300?img=10');
insert into alumno (id, name, email,created_at,updated_at,avatar)
values (11, 'Claire Garforth', 'cgarfortha@jigsy.com',NOW(),NOW(),'https://i.pravatar.cc/300?img=11');
insert into alumno (id, name, email,created_at,updated_at,avatar)
values (12, 'Vilhelmina Stutely', 'vstutelyb@naver.com',NOW(),NOW(),'https://i.pravatar.cc/300?img=12');
insert into alumno (id, name, email,created_at,updated_at,avatar)
values (13, 'Whitney Younglove', 'wyounglovec@digg.com',NOW(),NOW(),'https://i.pravatar.cc/300?img=13');
insert into alumno (id, name, email,created_at,updated_at,avatar)
values (14, 'Danika Allman', 'dallmand@washingtonpost.com',NOW(),NOW(),'https://i.pravatar.cc/300?img=14');
insert into alumno (id, name, email,created_at,updated_at,avatar)
values (15, 'Erv Grishenkov', 'egrishenkove@nationalgeographic.com',NOW(),NOW(),'https://i.pravatar.cc/300?img=15');
insert into alumno (id, name, email,created_at,updated_at,avatar)
values (16, 'Ilise Prettejohns', 'iprettejohnsf@sakura.ne.jp',NOW(),NOW(),'https://i.pravatar.cc/300?img=16');
insert into alumno (id, name, email,created_at,updated_at,avatar)
values (17, 'Oliviero Strafford', 'ostraffordg@google.com.br',NOW(),NOW(),'https://i.pravatar.cc/300?img=17');
insert into alumno (id, name, email,created_at,updated_at,avatar)
values (18, 'Judith Clist', 'jclisth@reference.com',NOW(),NOW(),'https://i.pravatar.cc/300?img=18');
insert into alumno (id, name, email,created_at,updated_at,avatar)
values (19, 'Merralee Probart', 'mprobarti@pen.io',NOW(),NOW(),'https://i.pravatar.cc/300?img=19');
insert into alumno (id, name, email,created_at,updated_at,avatar)
values (20, 'Amelina Hartshorn', 'ahartshornj@blogger.com',NOW(),NOW(),'https://i.pravatar.cc/300?img=20');

insert into alumno (id, name, email,created_at,updated_at,avatar)
values (21, 'Christean Suller', 'csullerk@yale.edu',NOW(),NOW(),'https://i.pravatar.cc/300?img=21');
insert into alumno (id, name, email,created_at,updated_at,avatar)
values (22, 'Wye Rubega', 'wrubegal@dagondesign.com',NOW(),NOW(),'https://i.pravatar.cc/300?img=22');
insert into alumno (id, name, email,created_at,updated_at,avatar)
values (23, 'Cathryn McHardy', 'cmchardym@gmpg.org',NOW(),NOW(),'https://i.pravatar.cc/300?img=23');
insert into alumno (id, name, email,created_at,updated_at,avatar)
values (24, 'Duffy Paraman', 'dparamann@cmu.edu',NOW(),NOW(),'https://i.pravatar.cc/300?img=24');
insert into alumno (id, name, email,created_at,updated_at,avatar)
values (25, 'Freddie Heams', 'fheamso@slate.com',NOW(),NOW(),'https://i.pravatar.cc/300?img=25');
insert into alumno (id, name, email,created_at,updated_at,avatar)
values (26, 'Evie Culbard', 'eculbardp@ifeng.com',NOW(),NOW(),'https://i.pravatar.cc/300?img=26');
insert into alumno (id, name, email,created_at,updated_at,avatar)
values (27, 'Shelley Farlambe', 'sfarlambeq@tamu.edu',NOW(),NOW(),'https://i.pravatar.cc/300?img=27');
insert into alumno (id, name, email,created_at,updated_at,avatar)
values (28, 'Phillipe Allanson', 'pallansonr@about.me',NOW(),NOW(),'https://i.pravatar.cc/300?img=28');
insert into alumno (id, name, email,created_at,updated_at,avatar)
values (29, 'Lilla Sparrowhawk', 'lsparrowhawks@t.co',NOW(),NOW(),'https://i.pravatar.cc/300?img=29');
insert into alumno (id, name, email,created_at,updated_at,avatar)
values (30, 'Keith Picknett', 'kpicknettt@bing.com',NOW(),NOW(),'https://i.pravatar.cc/300?img=30');
insert into alumno (id, name, email,created_at,updated_at,avatar)
values (31, 'Chrissy Marousek', 'cmarouseku@blogs.com',NOW(),NOW(),'https://i.pravatar.cc/300?img=31');
insert into alumno (id, name, email,created_at,updated_at,avatar)
values (32, 'Ernesta Yourell', 'eyourellv@prnewswire.com',NOW(),NOW(),'https://i.pravatar.cc/300?img=32');
insert into alumno (id, name, email,created_at,updated_at,avatar)
values (33, 'Valenka Reese', 'vreesew@nyu.edu',NOW(),NOW(),'https://i.pravatar.cc/300?img=33');
insert into alumno (id, name, email,created_at,updated_at,avatar)
values (34, 'Ernst Borton', 'ebortonx@facebook.com',NOW(),NOW(),'https://i.pravatar.cc/300?img=34');
insert into alumno (id, name, email,created_at,updated_at,avatar)
values (35, 'Johnathon Bocking', 'jbockingy@google.it',NOW(),NOW(),'https://i.pravatar.cc/300?img=35');
insert into alumno (id, name, email,created_at,updated_at,avatar)
values (36, 'Pet Rozec', 'prozecz@springer.com',NOW(),NOW(),'https://i.pravatar.cc/300?img=36');
insert into alumno (id, name, email,created_at,updated_at,avatar)
values (37, 'Isidor Lawton', 'ilawton10@wisc.edu',NOW(),NOW(),'https://i.pravatar.cc/300?img=37');
insert into alumno (id, name, email,created_at,updated_at,avatar)
values (38, 'Verna Roundtree', 'vroundtree11@youtube.com',NOW(),NOW(),'https://i.pravatar.cc/300?img=38');
insert into alumno (id, name, email,created_at,updated_at,avatar)
values (39, 'Winfield Lorman', 'wlorman12@hao123.com',NOW(),NOW(),'https://i.pravatar.cc/300?img=39');
insert into alumno (id, name, email,created_at,updated_at,avatar)
values (40, 'Eldon Seelbach', 'eseelbach13@merriam-webster.com',NOW(),NOW(),'https://i.pravatar.cc/300?img=40');
insert into alumno (id, name, email,created_at,updated_at,avatar)
values (41, 'Shldon eelbach', 'eelbach13@merriam-webster.com',NOW(),NOW(),'https://i.pravatar.cc/300?img=41');

insert into calificacion (id, alumno_id, modulo_id, score) values (1, 1, 1, 5.13);
insert into calificacion (id, alumno_id, modulo_id, score) values (2, 1, 2, 5.13);
insert into calificacion (id, alumno_id, modulo_id, score) values (3, 1, 3, 5.13);
insert into calificacion (id, alumno_id, modulo_id, score) values (4, 1, 4, 5.13);
insert into calificacion (id, alumno_id, modulo_id, score) values (5, 1, 5, 5.13);
insert into calificacion (id, alumno_id, modulo_id, score) values (6, 1, 6, 5.13);
insert into calificacion (id, alumno_id, modulo_id, score) values (7, 2, 1, 3.08);
insert into calificacion (id, alumno_id, modulo_id, score) values (8, 2, 2, 0.31);
insert into calificacion (id, alumno_id, modulo_id, score) values (9, 2, 3, 6.25);
insert into calificacion (id, alumno_id, modulo_id, score) values (10, 2, 4, 2.17);
insert into calificacion (id, alumno_id, modulo_id, score) values (11, 2, 5, 2.59);
insert into calificacion (id, alumno_id, modulo_id, score) values (12, 2, 6, 6.7);
insert into calificacion (id, alumno_id, modulo_id, score) values (13, 3, 1, 8.24);
insert into calificacion (id, alumno_id, modulo_id, score) values (14, 3, 2, 0.35);
insert into calificacion (id, alumno_id, modulo_id, score) values (15, 3, 3, 2.51);
insert into calificacion (id, alumno_id, modulo_id, score) values (16, 3, 4, 0.6);
insert into calificacion (id, alumno_id, modulo_id, score) values (17, 3, 5, 6.37);
insert into calificacion (id, alumno_id, modulo_id, score) values (18, 3, 6, 5.86);
insert into calificacion (id, alumno_id, modulo_id, score) values (19, 4, 1, 6.62);
insert into calificacion (id, alumno_id, modulo_id, score) values (20, 4, 2, 3.43);
insert into calificacion (id, alumno_id, modulo_id, score) values (21, 4, 3, 5.0);
insert into calificacion (id, alumno_id, modulo_id, score) values (22, 4, 4, 3.84);
insert into calificacion (id, alumno_id, modulo_id, score) values (23, 4, 5, 0.25);
insert into calificacion (id, alumno_id, modulo_id, score) values (24, 4, 6, 7.59);
insert into calificacion (id, alumno_id, modulo_id, score) values (25, 5, 1, 4.26);
insert into calificacion (id, alumno_id, modulo_id, score) values (26, 5, 2, 4.91);
insert into calificacion (id, alumno_id, modulo_id, score) values (27, 5, 3, 8.28);
insert into calificacion (id, alumno_id, modulo_id, score) values (28, 5, 4, 7.18);
insert into calificacion (id, alumno_id, modulo_id, score) values (29, 5, 5, 8.11);
insert into calificacion (id, alumno_id, modulo_id, score) values (30, 6, 6, 1.47);
insert into calificacion (id, alumno_id, modulo_id, score) values (31, 7, 1, 2.53);
insert into calificacion (id, alumno_id, modulo_id, score) values (32, 7, 2, 7.89);
insert into calificacion (id, alumno_id, modulo_id, score) values (33, 7, 3, 3.99);
insert into calificacion (id, alumno_id, modulo_id, score) values (34, 7, 4, 8.99);
insert into calificacion (id, alumno_id, modulo_id, score) values (35, 7, 5, 9.11);
insert into calificacion (id, alumno_id, modulo_id, score) values (36, 7, 6, 4.89);
insert into calificacion (id, alumno_id, modulo_id, score) values (37, 8, 1, 2.86);
insert into calificacion (id, alumno_id, modulo_id, score) values (38, 8, 2, 7.9);
insert into calificacion (id, alumno_id, modulo_id, score) values (39, 8, 3, 9.74);
insert into calificacion (id, alumno_id, modulo_id, score) values (40, 8, 4, 0.72);
insert into calificacion (id, alumno_id, modulo_id, score) values (41, 8, 5, 5.01);
insert into calificacion (id, alumno_id, modulo_id, score) values (42, 8, 6, 6.01);
insert into calificacion (id, alumno_id, modulo_id, score) values (43, 9, 1, 5.0);
insert into calificacion (id, alumno_id, modulo_id, score) values (44, 9, 2, 5.82);
insert into calificacion (id, alumno_id, modulo_id, score) values (45, 9, 3, 7.85);
insert into calificacion (id, alumno_id, modulo_id, score) values (46, 9, 4, 4.69);
insert into calificacion (id, alumno_id, modulo_id, score) values (47, 9, 5, 1.78);
insert into calificacion (id, alumno_id, modulo_id, score) values (48, 9, 6, 7.43);
insert into calificacion (id, alumno_id, modulo_id, score) values (49, 10, 1, 7.72);
insert into calificacion (id, alumno_id, modulo_id, score) values (50, 10, 2, 9.67);
insert into calificacion (id, alumno_id, modulo_id, score) values (51, 10, 3, 1.42);
insert into calificacion (id, alumno_id, modulo_id, score) values (52, 10, 4, 9.96);
insert into calificacion (id, alumno_id, modulo_id, score) values (53, 10, 5, 9.62);
insert into calificacion (id, alumno_id, modulo_id, score) values (54, 10, 6, 8.6);
insert into calificacion (id, alumno_id, modulo_id, score) values (55, 11, 1, 1.45);
insert into calificacion (id, alumno_id, modulo_id, score) values (56, 11, 2, 6.2);
insert into calificacion (id, alumno_id, modulo_id, score) values (57, 11, 3, 9.42);
insert into calificacion (id, alumno_id, modulo_id, score) values (58, 11, 4, 4.34);
insert into calificacion (id, alumno_id, modulo_id, score) values (59, 11, 5, 3.06);
insert into calificacion (id, alumno_id, modulo_id, score) values (60, 11, 6, 9.28);
insert into calificacion (id, alumno_id, modulo_id, score) values (61, 12, 1, 3.27);
insert into calificacion (id, alumno_id, modulo_id, score) values (62, 12, 2, 9.23);
insert into calificacion (id, alumno_id, modulo_id, score) values (63, 12, 3, 4.83);
insert into calificacion (id, alumno_id, modulo_id, score) values (64, 12, 4, 7.38);
insert into calificacion (id, alumno_id, modulo_id, score) values (65, 12, 5, 3.57);
insert into calificacion (id, alumno_id, modulo_id, score) values (66, 12, 6, 6.92);
insert into calificacion (id, alumno_id, modulo_id, score) values (67, 13, 1, 9.28);
insert into calificacion (id, alumno_id, modulo_id, score) values (68, 13, 2, 0.97);
insert into calificacion (id, alumno_id, modulo_id, score) values (69, 13, 3, 0.23);
insert into calificacion (id, alumno_id, modulo_id, score) values (70, 13, 4, 2.36);
insert into calificacion (id, alumno_id, modulo_id, score) values (71, 13, 5, 7.93);
insert into calificacion (id, alumno_id, modulo_id, score) values (72, 13, 6, 9.33);
insert into calificacion (id, alumno_id, modulo_id, score) values (73, 14, 1, 2.43);
insert into calificacion (id, alumno_id, modulo_id, score) values (74, 14, 2, 7.91);
insert into calificacion (id, alumno_id, modulo_id, score) values (75, 14, 3, 8.23);
insert into calificacion (id, alumno_id, modulo_id, score) values (76, 14, 4, 0.53);
insert into calificacion (id, alumno_id, modulo_id, score) values (77, 14, 5, 6.3);
insert into calificacion (id, alumno_id, modulo_id, score) values (78, 14, 6, 2.92);
insert into calificacion (id, alumno_id, modulo_id, score) values (79, 15, 1, 0.29);
insert into calificacion (id, alumno_id, modulo_id, score) values (80, 15, 2, 6.77);
insert into calificacion (id, alumno_id, modulo_id, score) values (81, 15, 3, 8.82);
insert into calificacion (id, alumno_id, modulo_id, score) values (82, 15, 4, 1.18);
insert into calificacion (id, alumno_id, modulo_id, score) values (83, 15, 5, 7.58);
insert into calificacion (id, alumno_id, modulo_id, score) values (84, 15, 6, 7.31);
insert into calificacion (id, alumno_id, modulo_id, score) values (85, 16, 1, 3.62);
insert into calificacion (id, alumno_id, modulo_id, score) values (86, 16, 2, 9.98);
insert into calificacion (id, alumno_id, modulo_id, score) values (87, 16, 3, 1.61);
insert into calificacion (id, alumno_id, modulo_id, score) values (88, 16, 4, 4.95);
insert into calificacion (id, alumno_id, modulo_id, score) values (89, 16, 5, 0.72);
insert into calificacion (id, alumno_id, modulo_id, score) values (90, 16, 6, 1.79);
insert into calificacion (id, alumno_id, modulo_id, score) values (91, 17, 1, 8.72);
insert into calificacion (id, alumno_id, modulo_id, score) values (92, 17, 2, 6.77);
insert into calificacion (id, alumno_id, modulo_id, score) values (93, 17, 3, 2.13);
insert into calificacion (id, alumno_id, modulo_id, score) values (94, 17, 4, 7.35);
insert into calificacion (id, alumno_id, modulo_id, score) values (95, 17, 5, 5.11);
insert into calificacion (id, alumno_id, modulo_id, score) values (96, 17, 6, 7.57);
insert into calificacion (id, alumno_id, modulo_id, score) values (97, 18, 1, 1.13);
insert into calificacion (id, alumno_id, modulo_id, score) values (98, 18, 2, 4.41);
insert into calificacion (id, alumno_id, modulo_id, score) values (99, 18, 3, 0.75);
insert into calificacion (id, alumno_id, modulo_id, score) values (100, 18, 4, 1.77);
insert into calificacion (id, alumno_id, modulo_id, score) values (101, 18, 5, 0.72);
insert into calificacion (id, alumno_id, modulo_id, score) values (102, 18, 6, 1.79);
insert into calificacion (id, alumno_id, modulo_id, score) values (103, 19, 1, 8.72);
insert into calificacion (id, alumno_id, modulo_id, score) values (104, 19, 2, 6.77);
insert into calificacion (id, alumno_id, modulo_id, score) values (105, 19, 3, 2.13);
insert into calificacion (id, alumno_id, modulo_id, score) values (106, 19, 4, 7.35);
insert into calificacion (id, alumno_id, modulo_id, score) values (107, 19, 5, 5.11);
insert into calificacion (id, alumno_id, modulo_id, score) values (108, 19, 6, 7.57);
insert into calificacion (id, alumno_id, modulo_id, score) values (109, 20, 1, 1.13);
insert into calificacion (id, alumno_id, modulo_id, score) values (110, 20, 2, 4.41);
insert into calificacion (id, alumno_id, modulo_id, score) values (111, 20, 3, 0.75);
insert into calificacion (id, alumno_id, modulo_id, score) values (112, 20, 4, 1.77);
insert into calificacion (id, alumno_id, modulo_id, score) values (113, 19, 5, 5.11);
insert into calificacion (id, alumno_id, modulo_id, score) values (114, 19, 6, 7.57);
insert into calificacion (id, alumno_id, modulo_id, score) values (115, 20, 1, 1.13);
insert into calificacion (id, alumno_id, modulo_id, score) values (116, 20, 2, 4.41);
insert into calificacion (id, alumno_id, modulo_id, score) values (117, 20, 3, 0.75);
insert into calificacion (id, alumno_id, modulo_id, score) values (118, 20, 4, 1.77);
insert into calificacion (id, alumno_id, modulo_id, score) values (119, 20, 5, 5.11);
insert into calificacion (id, alumno_id, modulo_id, score) values (120, 20, 6, 7.57);

insert into calificacion (id, alumno_id, modulo_id, score) values (121, 21, 7, 0.43);
insert into calificacion (id, alumno_id, modulo_id, score) values (122, 21, 8, 4.86);
insert into calificacion (id, alumno_id, modulo_id, score) values (123, 21, 9, 1.59);
insert into calificacion (id, alumno_id, modulo_id, score) values (124, 21, 10, 1.51);
insert into calificacion (id, alumno_id, modulo_id, score) values (125, 21, 11, 4.51);
insert into calificacion (id, alumno_id, modulo_id, score) values (126, 21, 12, 1.5);
insert into calificacion (id, alumno_id, modulo_id, score) values (127, 21, 13, 0.39);
insert into calificacion (id, alumno_id, modulo_id, score) values (128, 21, 14, 3.62);
insert into calificacion (id, alumno_id, modulo_id, score) values (129, 21, 15, 3.92);
insert into calificacion (id, alumno_id, modulo_id, score) values (130, 22, 7, 4.66);
insert into calificacion (id, alumno_id, modulo_id, score) values (131, 22, 8, 0.61);
insert into calificacion (id, alumno_id, modulo_id, score) values (132, 22, 9, 9.01);
insert into calificacion (id, alumno_id, modulo_id, score) values (133, 22, 10, 0.95);
insert into calificacion (id, alumno_id, modulo_id, score) values (134, 22, 11, 2.78);
insert into calificacion (id, alumno_id, modulo_id, score) values (135, 22, 12, 0.51);
insert into calificacion (id, alumno_id, modulo_id, score) values (136, 22, 13, 9.83);
insert into calificacion (id, alumno_id, modulo_id, score) values (137, 22, 14, 5.9);
insert into calificacion (id, alumno_id, modulo_id, score) values (138, 22, 15, 0.48);
insert into calificacion (id, alumno_id, modulo_id, score) values (139, 23, 7, 5.49);
insert into calificacion (id, alumno_id, modulo_id, score) values (140, 23, 8, 4.92);
insert into calificacion (id, alumno_id, modulo_id, score) values (141, 23, 9, 9.02);
insert into calificacion (id, alumno_id, modulo_id, score) values (142, 23, 10, 7.39);
insert into calificacion (id, alumno_id, modulo_id, score) values (143, 23, 11, 3.91);
insert into calificacion (id, alumno_id, modulo_id, score) values (144, 23, 12, 5.15);
insert into calificacion (id, alumno_id, modulo_id, score) values (145, 23, 13, 9.05);
insert into calificacion (id, alumno_id, modulo_id, score) values (146, 23, 14, 3.67);
insert into calificacion (id, alumno_id, modulo_id, score) values (147, 23, 15, 2.38);
insert into calificacion (id, alumno_id, modulo_id, score) values (148, 24, 7, 1.84);
insert into calificacion (id, alumno_id, modulo_id, score) values (149, 24, 8, 4.37);
insert into calificacion (id, alumno_id, modulo_id, score) values (150, 24, 9, 5.99);
insert into calificacion (id, alumno_id, modulo_id, score) values (151, 24, 10, 1.34);
insert into calificacion (id, alumno_id, modulo_id, score) values (152, 24, 11, 6.09);
insert into calificacion (id, alumno_id, modulo_id, score) values (153, 24, 12, 4.59);
insert into calificacion (id, alumno_id, modulo_id, score) values (154, 24, 13, 1.62);
insert into calificacion (id, alumno_id, modulo_id, score) values (155, 24, 14, 9.69);
insert into calificacion (id, alumno_id, modulo_id, score) values (156, 24, 15, 7.78);
insert into calificacion (id, alumno_id, modulo_id, score) values (157, 25, 7, 7.15);
insert into calificacion (id, alumno_id, modulo_id, score) values (158, 25, 8, 9.31);
insert into calificacion (id, alumno_id, modulo_id, score) values (159, 25, 9, 4.48);
insert into calificacion (id, alumno_id, modulo_id, score) values (160, 25, 10, 9.43);
insert into calificacion (id, alumno_id, modulo_id, score) values (161, 25, 11, 7.86);
insert into calificacion (id, alumno_id, modulo_id, score) values (162, 25, 12, 5.22);
insert into calificacion (id, alumno_id, modulo_id, score) values (163, 25, 13, 7.15);
insert into calificacion (id, alumno_id, modulo_id, score) values (164, 25, 14, 7.61);
insert into calificacion (id, alumno_id, modulo_id, score) values (165, 25, 15, 4.89);
insert into calificacion (id, alumno_id, modulo_id, score) values (166, 26, 7, 2.83);
insert into calificacion (id, alumno_id, modulo_id, score) values (167, 26, 8, 7.34);
insert into calificacion (id, alumno_id, modulo_id, score) values (168, 26, 9, 8.73);
insert into calificacion (id, alumno_id, modulo_id, score) values (169, 26, 10, 3.84);
insert into calificacion (id, alumno_id, modulo_id, score) values (170, 26, 11, 0.22);
insert into calificacion (id, alumno_id, modulo_id, score) values (171, 26, 12, 8.63);
insert into calificacion (id, alumno_id, modulo_id, score) values (172, 26, 13, 2.66);
insert into calificacion (id, alumno_id, modulo_id, score) values (173, 26, 14, 7.04);
insert into calificacion (id, alumno_id, modulo_id, score) values (174, 26, 15, 0.67);
insert into calificacion (id, alumno_id, modulo_id, score) values (175, 27, 7, 6.14);
insert into calificacion (id, alumno_id, modulo_id, score) values (176, 27, 8, 8.46);
insert into calificacion (id, alumno_id, modulo_id, score) values (177, 27, 9, 3.85);
insert into calificacion (id, alumno_id, modulo_id, score) values (178, 27, 10, 8.11);
insert into calificacion (id, alumno_id, modulo_id, score) values (179, 27, 11, 6.05);
insert into calificacion (id, alumno_id, modulo_id, score) values (180, 27, 12, 9.74);
insert into calificacion (id, alumno_id, modulo_id, score) values (181, 27, 13, 7.0);
insert into calificacion (id, alumno_id, modulo_id, score) values (182, 27, 14, 0.04);
insert into calificacion (id, alumno_id, modulo_id, score) values (183, 27, 15, 3.07);
insert into calificacion (id, alumno_id, modulo_id, score) values (184, 28, 7, 9.04);
insert into calificacion (id, alumno_id, modulo_id, score) values (185, 28, 8, 6.06);
insert into calificacion (id, alumno_id, modulo_id, score) values (186, 28, 9, 5.07);
insert into calificacion (id, alumno_id, modulo_id, score) values (187, 28, 10, 5.01);
insert into calificacion (id, alumno_id, modulo_id, score) values (188, 28, 11, 3.98);
insert into calificacion (id, alumno_id, modulo_id, score) values (189, 28, 12, 9.4);
insert into calificacion (id, alumno_id, modulo_id, score) values (190, 28, 13, 9.2);
insert into calificacion (id, alumno_id, modulo_id, score) values (191, 28, 14, 7.68);
insert into calificacion (id, alumno_id, modulo_id, score) values (192, 28, 15, 2.0);
insert into calificacion (id, alumno_id, modulo_id, score) values (193, 29, 7, 6.97);
insert into calificacion (id, alumno_id, modulo_id, score) values (194, 29, 8, 8.53);
insert into calificacion (id, alumno_id, modulo_id, score) values (195, 29, 9, 3.87);
insert into calificacion (id, alumno_id, modulo_id, score) values (196, 29, 10, 3.59);
insert into calificacion (id, alumno_id, modulo_id, score) values (197, 29, 11, 0.22);
insert into calificacion (id, alumno_id, modulo_id, score) values (198, 29, 12, 5.0);
insert into calificacion (id, alumno_id, modulo_id, score) values (199, 29, 13, 0.21);
insert into calificacion (id, alumno_id, modulo_id, score) values (200, 29, 14, 0.65);
insert into calificacion (id, alumno_id, modulo_id, score) values (201, 29, 15, 2.07);
insert into calificacion (id, alumno_id, modulo_id, score) values (202, 30, 7, 9.06);
insert into calificacion (id, alumno_id, modulo_id, score) values (203, 30, 8, 6.56);
insert into calificacion (id, alumno_id, modulo_id, score) values (204, 30, 9, 1.44);
insert into calificacion (id, alumno_id, modulo_id, score) values (205, 30, 10, 5.87);
insert into calificacion (id, alumno_id, modulo_id, score) values (206, 30, 11, 2.16);
insert into calificacion (id, alumno_id, modulo_id, score) values (207, 30, 12, 3.31);
insert into calificacion (id, alumno_id, modulo_id, score) values (208, 30, 13, 6.93);
insert into calificacion (id, alumno_id, modulo_id, score) values (209, 30, 14, 0.91);
insert into calificacion (id, alumno_id, modulo_id, score) values (210, 30, 15, 1.63);
insert into calificacion (id, alumno_id, modulo_id, score) values (211, 31, 7, 2.07);
insert into calificacion (id, alumno_id, modulo_id, score) values (212, 31, 8, 9.06);
insert into calificacion (id, alumno_id, modulo_id, score) values (213, 31, 9, 6.56);
insert into calificacion (id, alumno_id, modulo_id, score) values (214, 31, 10, 1.44);
insert into calificacion (id, alumno_id, modulo_id, score) values (215, 31, 11, 5.87);
insert into calificacion (id, alumno_id, modulo_id, score) values (216, 31, 12, 2.16);
insert into calificacion (id, alumno_id, modulo_id, score) values (217, 31, 13, 3.31);
insert into calificacion (id, alumno_id, modulo_id, score) values (218, 31, 14, 6.93);
insert into calificacion (id, alumno_id, modulo_id, score) values (219, 31, 15, 0.91);
insert into calificacion (id, alumno_id, modulo_id, score) values (220, 32, 7, 1.63);
insert into calificacion (id, alumno_id, modulo_id, score) values (221, 32, 8, 0.43);
insert into calificacion (id, alumno_id, modulo_id, score) values (222, 32, 9, 4.86);
insert into calificacion (id, alumno_id, modulo_id, score) values (223, 32, 10, 1.59);
insert into calificacion (id, alumno_id, modulo_id, score) values (224, 32, 11, 1.51);
insert into calificacion (id, alumno_id, modulo_id, score) values (225, 32, 12, 4.51);
insert into calificacion (id, alumno_id, modulo_id, score) values (226, 32, 13, 1.5);
insert into calificacion (id, alumno_id, modulo_id, score) values (227, 32, 14, 0.39);
insert into calificacion (id, alumno_id, modulo_id, score) values (228, 32, 15, 3.62);
insert into calificacion (id, alumno_id, modulo_id, score) values (229, 33, 7, 3.92);
insert into calificacion (id, alumno_id, modulo_id, score) values (230, 33, 8, 4.66);
insert into calificacion (id, alumno_id, modulo_id, score) values (231, 33, 9, 0.61);
insert into calificacion (id, alumno_id, modulo_id, score) values (232, 33, 10, 9.01);
insert into calificacion (id, alumno_id, modulo_id, score) values (233, 33, 11, 0.95);
insert into calificacion (id, alumno_id, modulo_id, score) values (234, 33, 12, 2.78);
insert into calificacion (id, alumno_id, modulo_id, score) values (235, 33, 13, 0.51);
insert into calificacion (id, alumno_id, modulo_id, score) values (236, 33, 14, 9.83);
insert into calificacion (id, alumno_id, modulo_id, score) values (237, 33, 15, 5.9);
insert into calificacion (id, alumno_id, modulo_id, score) values (238, 34, 7, 0.48);
insert into calificacion (id, alumno_id, modulo_id, score) values (239, 34, 8, 5.49);
insert into calificacion (id, alumno_id, modulo_id, score) values (240, 34, 9, 4.92);
insert into calificacion (id, alumno_id, modulo_id, score) values (241, 34, 10, 9.02);
insert into calificacion (id, alumno_id, modulo_id, score) values (242, 34, 11, 7.39);
insert into calificacion (id, alumno_id, modulo_id, score) values (243, 34, 12, 3.91);
insert into calificacion (id, alumno_id, modulo_id, score) values (244, 34, 13, 5.15);
insert into calificacion (id, alumno_id, modulo_id, score) values (245, 34, 14, 9.05);
insert into calificacion (id, alumno_id, modulo_id, score) values (246, 34, 15, 3.67);
insert into calificacion (id, alumno_id, modulo_id, score) values (247, 35, 7, 2.38);
insert into calificacion (id, alumno_id, modulo_id, score) values (248, 35, 8, 1.84);
insert into calificacion (id, alumno_id, modulo_id, score) values (249, 35, 9, 4.37);
insert into calificacion (id, alumno_id, modulo_id, score) values (250, 35, 10, 5.99);
insert into calificacion (id, alumno_id, modulo_id, score) values (251, 35, 11, 1.34);
insert into calificacion (id, alumno_id, modulo_id, score) values (252, 35, 12, 6.09);
insert into calificacion (id, alumno_id, modulo_id, score) values (253, 35, 13, 4.59);
insert into calificacion (id, alumno_id, modulo_id, score) values (254, 35, 14, 1.62);
insert into calificacion (id, alumno_id, modulo_id, score) values (255, 35, 15, 9.69);
insert into calificacion (id, alumno_id, modulo_id, score) values (256, 36, 7, 7.78);
insert into calificacion (id, alumno_id, modulo_id, score) values (257, 36, 8, 7.15);
insert into calificacion (id, alumno_id, modulo_id, score) values (258, 36, 9, 9.31);
insert into calificacion (id, alumno_id, modulo_id, score) values (259, 36, 10, 4.48);
insert into calificacion (id, alumno_id, modulo_id, score) values (260, 36, 11, 9.43);
insert into calificacion (id, alumno_id, modulo_id, score) values (261, 36, 12, 7.86);
insert into calificacion (id, alumno_id, modulo_id, score) values (262, 36, 13, 5.22);
insert into calificacion (id, alumno_id, modulo_id, score) values (263, 36, 14, 7.15);
insert into calificacion (id, alumno_id, modulo_id, score) values (264, 36, 15, 7.61);
insert into calificacion (id, alumno_id, modulo_id, score) values (265, 37, 7, 4.89);
insert into calificacion (id, alumno_id, modulo_id, score) values (266, 37, 8, 2.83);
insert into calificacion (id, alumno_id, modulo_id, score) values (267, 37, 9, 7.34);
insert into calificacion (id, alumno_id, modulo_id, score) values (268, 37, 10, 8.73);
insert into calificacion (id, alumno_id, modulo_id, score) values (269, 37, 11, 3.84);
insert into calificacion (id, alumno_id, modulo_id, score) values (270, 37, 12, 0.49);
insert into calificacion (id, alumno_id, modulo_id, score) values (271, 37, 13, 6.08);
insert into calificacion (id, alumno_id, modulo_id, score) values (272, 37, 14, 2.66);
insert into calificacion (id, alumno_id, modulo_id, score) values (273, 37, 15, 7.04);
insert into calificacion (id, alumno_id, modulo_id, score) values (274, 38, 7, 0.67);
insert into calificacion (id, alumno_id, modulo_id, score) values (275, 38, 8, 6.14);
insert into calificacion (id, alumno_id, modulo_id, score) values (276, 38, 9, 8.46);
insert into calificacion (id, alumno_id, modulo_id, score) values (277, 38, 10, 3.85);
insert into calificacion (id, alumno_id, modulo_id, score) values (278, 38, 11, 8.11);
insert into calificacion (id, alumno_id, modulo_id, score) values (279, 38, 12, 6.05);
insert into calificacion (id, alumno_id, modulo_id, score) values (280, 38, 13, 9.74);
insert into calificacion (id, alumno_id, modulo_id, score) values (281, 38, 14, 7.0);
insert into calificacion (id, alumno_id, modulo_id, score) values (282, 38, 15, 0.04);
insert into calificacion (id, alumno_id, modulo_id, score) values (283, 39, 7, 3.07);
insert into calificacion (id, alumno_id, modulo_id, score) values (284, 39, 8, 9.04);
insert into calificacion (id, alumno_id, modulo_id, score) values (285, 39, 9, 6.06);
insert into calificacion (id, alumno_id, modulo_id, score) values (286, 39, 10, 5.07);
insert into calificacion (id, alumno_id, modulo_id, score) values (287, 39, 11, 5.01);
insert into calificacion (id, alumno_id, modulo_id, score) values (288, 39, 12, 3.98);
insert into calificacion (id, alumno_id, modulo_id, score) values (289, 39, 13, 9.4);
insert into calificacion (id, alumno_id, modulo_id, score) values (290, 39, 14, 9.2);
insert into calificacion (id, alumno_id, modulo_id, score) values (291, 39, 15, 7.68);
insert into calificacion (id, alumno_id, modulo_id, score) values (292, 40, 7, 2.0);
insert into calificacion (id, alumno_id, modulo_id, score) values (293, 40, 8, 6.97);
insert into calificacion (id, alumno_id, modulo_id, score) values (294, 40, 9, 8.53);
insert into calificacion (id, alumno_id, modulo_id, score) values (295, 40, 10, 3.87);
insert into calificacion (id, alumno_id, modulo_id, score) values (296, 40, 11, 3.59);
insert into calificacion (id, alumno_id, modulo_id, score) values (297, 40, 12, 0.22);
insert into calificacion (id, alumno_id, modulo_id, score) values (298, 40, 13, 5.0);
insert into calificacion (id, alumno_id, modulo_id, score) values (299, 40, 14, 0.21);
insert into calificacion (id, alumno_id, modulo_id, score) values (300, 40, 15, 0.65);

insert into usuarios (id, full_name, email, username, password, avatar, created_at, last_password_change_at,alumno_id)
values (1, 'Admin admin', 'admin@prueba.net', 'admin', '$2a$10$vPaqZvZkz6jhb7U7k/V/v.5vprfNdOnh4sxi/qpPRkYTzPmFlI9p2',
        'https://api.lorem.space/image/face?w=150&h=150', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP,40);

insert into usuario_roles (usuario_id, roles)
values (1, 'USER');
insert into usuario_roles (usuario_id, roles)
values (1, 'ADMIN');
