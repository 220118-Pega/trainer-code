-- seeding script, contains all table structure including dummy data
-- DROP TABLE batches;
-- DROP TABLE trainers;
-- DROP TABLE associates;

CREATE TABLE associates (-- column name, datatype, additional constraints
 associate_name TEXT NOT NULL,
                     associate_locale VARCHAR(2) NOT NULL,
                                                 reva_points INT NOT NULL,
                                                                 id SERIAL PRIMARY KEY);


CREATE TABLE trainers (trainer_name TEXT NOT NULL,
                                         campus TEXT NOT NULL,
                                                     caffeine_level INT NOT NULL,
                                                                        id SERIAL PRIMARY KEY);


CREATE TABLE batches (id SERIAL PRIMARY KEY, -- referencing PK in another table:
 -- column_Name type references parent_table(parent_column)
 trainer_id int references trainers(id),
                           associate_id int references associates(id));

-- Adding data to your tables

INSERT INTO associates (associate_name, associate_locale, reva_points)
VALUES ('Anna',
        'CT',
        150), ('Janel',
               'AZ',
               150), ('Eden',
                      'PA',
                      150), ('Kareem',
                             'LA',
                             -50), ('William',
                                    'WI',
                                    100), ('Shelbe',
                                           'GA',
                                           -50), ('Jackie',
                                                  'FL',
                                                  -50), ('Ace',
                                                         'XE',
                                                         50);


insert into trainers (trainer_name, campus, caffeine_level)
values ('Ben',
        'USF',
        50), ('Jacob',
              'USF',
              100), ('Kelsey',
                     'UTA',
                     0), ('Marielle',
                          'USF',
                          75), ('Juniper',
                                'USF',
                                50), ('Sophia',
                                      'Reston',
                                      50), ('Sierra',
                                            'WVU',
                                            60);


insert into batches (associate_id, trainer_id)
values (4,
        5), (5,
             4), (6,
                  3), (7,
                       7), (8,
                            6);

