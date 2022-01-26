-- executed against batch db, run the batch_db.sql script first if not yet initialized

Select *
from associates;


Select *
from trainers;


Select *
from batches;

-- Select clause

Select count(*),
       reva_points
from associates
where associate_locale <> 'AZ'
group by reva_points
having reva_points > 0
order by reva_points desc;

-- Getting assocs and their associated trainer (try it out with different types of joins!)

Select associate_name,
       trainer_name
from associates
right join batches on associates.id = batches.associate_id
right join trainers on batches.trainer_id = trainers.id;

-- getting associates not assigned to trainer

select associate_name
from associates
left join batches on associates.id = batches.associate_id
where associate_id is null;


    (select associate_name
     from associates)
except
    (select associate_name
     from associates
     inner join batches on associates.id = batches.associate_id);


select associate_name
from associates
where id not in
        (select associate_id
         from batches);