-- drop sequence my_poid_sequence;

-- Data for simple person use
insert into Person(id, version, firstname, lastname) values(-101, 1, 'Christopher', 'Robin');
insert into Person(id, version, firstname, lastname) values(-102, 1, 'Ian', 'Darwin');

-- Data for Actors
insert into Person(id, version, firstName, lastName) values(-103, 1, 'Harrison', 'Ford')
insert into Actor(id) values (-103)
insert into Person(id, version, firstName, lastName) values(-104, 1, 'Mark', 'Hamill')
insert into Actor(id) values (-104)
insert into Person(id, version, firstName, lastName) values(-105, 1, 'Carrie', 'Fisher')
insert into Actor(id) values (-105)
insert into Person(id, version, firstName, lastName) values(-106, 1, 'Clark', 'Gable')
insert into Actor(id) values (-106)
insert into Person(id, version, firstName, lastName) values(-107, 1, 'Vivien', 'Leigh')
insert into Actor(id) values (-107)

-- Data for Videos
insert into Recording (id, version, title, price) values(-200, 1, 'Gone With The Wind', 0)
insert into VideoRecording (id, year) values (-200, 1939)
insert into Recording (id, version, title, price) values(-201, 1, 'Star Wars IV: A New Hope', 0)
insert into VideoRecording (id, year) values (-201, 1977)
insert into Recording (id, version, title, price) values(-202, 1, 'Indiana Jones: Raiders of the Lost Ark', 0)
insert into VideoRecording (id, year) values (-202, 1981)
insert into Recording (id, version, title, price) values(-203, 1, 'Patriot Games', 0)
insert into VideoRecording (id, year) values (-203, 1992)

-- Video<-->Actors join table
insert into Actor_VideoRecording(actors_id, videos_id) values (-103, -201)
insert into Actor_VideoRecording(actors_id, videos_id) values (-103, -202)
insert into Actor_VideoRecording(actors_id, videos_id) values (-103, -203)
insert into Actor_VideoRecording(actors_id, videos_id) values (-104, -201)
insert into Actor_VideoRecording(actors_id, videos_id) values (-105, -201)
insert into Actor_VideoRecording(actors_id, videos_id) values (-106, -200)
insert into Actor_VideoRecording(actors_id, videos_id) values (-107, -200)

-- Composite Primary Key demo
-- insert into fish(speciesId, individualId, fishName) values(255, 001, 'Fred')
