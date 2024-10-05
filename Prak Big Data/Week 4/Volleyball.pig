players = LOAD 'C:/downloads/volley/clean_data.csv' USING PigStorage(',') AS ( index:int, name:chararray, date_of_birth:chararray, height:int, weight:int, spike:int, block:int, position_number:int);
filtered_players = FILTER players BY spike > 280;
grouped_by_name = GROUP filtered_players BY name;
DUMP grouped_by_name;
STORE grouped_by_name INTO 'C:/downloads/output3' USING PigStorage(',');