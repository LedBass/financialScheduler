insert into user
values (0, 'Main User');

insert into user
values (1, 'Other User');

insert into bank_account 
values (0, 300.00, 0);

insert into bank_account
values (1, 150.00, 1);

insert into transaction_type (id, transaction_type, days_to_transaction_interval, transaction_tax_percentage, per_day_percentage_tax, transaction_tax, per_day_fixed_tax, description)
values  (0, 'TYPE_A same day', '0-0', 3.00, FALSE, 3.00, FALSE, 'Type A - Same Day. This transaction is a mixed tax transaction. The percentage is calculated by the diference between the day of the transaction submit and the day of the achedulling of the transaction plus $3.00 as fixed tax.');

insert into transaction_type (id, transaction_type, days_to_transaction_interval, transaction_tax_percentage, per_day_percentage_tax, transaction_tax, per_day_fixed_tax, description)
values (1, 'TYPE_B Up to 10 days', '0-10', 0.00, FALSE, 12.00, TRUE, 'Type B - 12%. per day up to 10 days. This transaction is per day until the transaction operation. it will cost the fixed tax multiplied by the days until the transaction is made.');

insert into transaction_type (id, transaction_type, days_to_transaction_interval, transaction_tax_percentage, per_day_percentage_tax, transaction_tax, per_day_fixed_tax, description)
values (2, 'TYPE_C Up to 20 days', '11-20', 8.00, FALSE, 0.00, FALSE, 'Type C - 8%. It will cost the fixed tax multiplied by the days until the transaction is made.');

insert into transaction_type (id, transaction_type, days_to_transaction_interval, transaction_tax_percentage, per_day_percentage_tax, transaction_tax, per_day_fixed_tax, description)
values (3, 'TYPE_C Up to 30 days', '21-30', 6.00, FALSE, 0.00, FALSE, 'Type C- 6%. It will cost the fixed tax multiplied by the days until the transaction is made.');

insert into transaction_type (id, transaction_type, days_to_transaction_interval, transaction_tax_percentage, per_day_percentage_tax, transaction_tax, per_day_fixed_tax, max_transaction_value, description)
values (4, 'TYPE_C Up to or more than 40 days', '31-', 4.00, FALSE, 0.00, FALSE, 100.000, ' Type C 4% up to 31 days or more, limited to 100.00. It will cost the fixed tax multiplied by the days until the transaction is made.');

insert into transaction_type (id, transaction_type, days_to_transaction_interval, transaction_tax_percentage, per_day_percentage_tax, transaction_tax, per_day_fixed_tax, minimal_transaction_value, description)
values (5, 'TYPE_C more than 40 days', '41-', 2.00, FALSE, 0.00, FALSE, 100.001, 'Type C 2% more than 40 days with minimum value of 100.001.  if the operation has value higher than $100.000 in value. it will cost the fixed tax multiplied by the days until the transaction is made.');

