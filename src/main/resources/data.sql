insert into user
values (0, 'main user');

insert into user
values (1, 'other user');

insert into bank_account 
values (0, 300.00, 0);

insert into bank_account
values (1, 150.00, 1);

insert into transaction_type (id, transaction_type, days_to_transaction_interval, transaction_tax_percentage, per_day_percentage_tax, transaction_tax, per_day_fixed_tax, description)
values  (0, 'TYPE_A same day', '0-0', 3.000, FALSE, 3.000, FALSE, 'This transaction is a mixed tax transaction. It will use both tax and and tax persentage. \n The percentage is calculated by the diference between the day of the transaction submit and the day of the achedulling of the transaction plus $3.00 as fixed tax.');

insert into transaction_type (id, transaction_type, days_to_transaction_interval, transaction_tax_percentage, per_day_percentage_tax, transaction_tax, per_day_fixed_tax, description)
values (1, 'TYPE_B Up to 10 days', '0-10', 0.000, FALSE, 12.00, TRUE, 'This transaction is per day until the transaction operation. it will cost the fixed tax multiplied by the days until the transaction is made.');

insert into transaction_type (id, transaction_type, days_to_transaction_interval, transaction_tax_percentage, per_day_percentage_tax, transaction_tax, per_day_fixed_tax, description)
values (2, 'TYPE_C Up to 20 days', '11-20', 8.000, FALSE, 0.00, FALSE, 'This transaction is per day until the transaction operation. it will cost the fixed tax multiplied by the days until the transaction is made.');

insert into transaction_type (id, transaction_type, days_to_transaction_interval, transaction_tax_percentage, per_day_percentage_tax, transaction_tax, per_day_fixed_tax, description)
values (3, 'TYPE_C Up to 30 days', '21-30', 6.000, FALSE, 0.00, FALSE, 'This transaction is per day until the transaction operation. it will cost the fixed tax multiplied by the days until the transaction is made.');

insert into transaction_type (id, transaction_type, days_to_transaction_interval, transaction_tax_percentage, per_day_percentage_tax, transaction_tax, per_day_fixed_tax, max_transaction_value, description)
values (4, 'TYPE_C Up to or more than 40 days', '31-', 4.000, FALSE, 0.00, FALSE, 100.000, 'This transaction is per day until te transaction operation. it will cost the fixed tax multiplied by the days until the transaction is made.');

insert into transaction_type (id, transaction_type, days_to_transaction_interval, transaction_tax_percentage, per_day_percentage_tax, transaction_tax, per_day_fixed_tax, minimal_transaction_value, description)
values (5, 'TYPE_C more than 40 days', '41-', 2.00, FALSE, 0.00, FALSE, 100.001, 'This transaction is per day until the transaction operation if the operation has value equals or higher than $100.000 in value. it will cost the fixed tax multiplied by the days until the transaction is made.');

