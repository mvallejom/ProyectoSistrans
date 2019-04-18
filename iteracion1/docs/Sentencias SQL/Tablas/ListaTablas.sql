SELECT atb.table_name, atb.column_name, atb.data_type, ac.constraint_name
FROM ALL_TAB_COLUMNS atb
JOIN ALL_CONS_COLUMNS ac
    ON atb.table_name = ac.table_name
        AND atb.column_name = ac.column_name
WHERE atb.owner = 'ISIS2304C091910'
ORDER BY table_name, column_name;

SELECT *
FROM ALL_CONSTRAINTS
WHERE owner = 'ISIS2304C091910';