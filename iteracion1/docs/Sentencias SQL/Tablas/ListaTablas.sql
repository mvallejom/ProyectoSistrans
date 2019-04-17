SELECT atb.table_name, atb.column_name, atb.data_type, ac.constraint_name
FROM ALL_TAB_COLUMNS atb
JOIN ALL_CONSTRAINTS ac
    ON atb.table_name = ac.table_name
WHERE atb.owner = 'ISIS2304C091910';