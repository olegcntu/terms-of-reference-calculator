# terms-of-reference-calculator
Тестовое задание 
Разработать приложение, которое будет предоставлять следующие
возможности:
1. Вводить арифметические выражения, содержащие целые и дробные
числа, а также математические операции +, -, *, / и круглые скобки,
уровень вложенности скобок – произвольный.
2. Проверять введенное выражение на корректность расстановки скобок
3. Проверять корректность введенного выражения (не должно быть 2
знаков математических операций подряд, например, недопустимо
выражение 3+*4, в то же время, выражение 4*-7 является
допустимым)
4. Если выражение является корректным, вычислить его значение и
сохранить выражение и вычисленное значение в БД.
5. Предоставить возможность просмотра и редактирования выражений в
БД. Если выражение после редактирования остается корректным,
скорректировать и его значение в БД.
6. Реализовать функции поиска выражений в БД по их результатам.
Например, возможен запрос: найти все выражения, значения которых
равны (а также больше, меньше...) указанному значению.
7. Проект должен быть реализован с использованием системы сборки
Maven в одной из сред разработки: IntelliJ IDEA или Eclipse.
8. Проект должен быть загружен в репозиторий GitHub и предоставлена
ссылка для его получения. Также допустимо выслать архив с
проектом.

Примечания.
В работе использовать Java 11 или 17.
Рекомендуется использование таких СУБД: MySQL, MariaDB или
PostgreSQL.
Приветствуется использование JUnit и других средств тестирования.
Допускается использовать файлы (вместо БД) для хранения информации о
введенных и редактируемых арифметических выражениях.
Обязательными для выполнения являются пп.1-3 и 8. Если п.4-7 не
выполняются, то выполнить дополнительное задание:
- посчитать количество чисел в строке, введенной пользователем.

![image](https://user-images.githubusercontent.com/66881230/164686634-84007e0b-11ec-4d88-bfbc-19440067dfc2.png)
to calculate the expression, you need to enter the expression itself in the appropriate line and click the "to count" button, the expression will be calculated and the result will be displayed on the screen, and the expression itself, together with the result, will be automatically saved in the database

![image](https://user-images.githubusercontent.com/66881230/164687407-00e5259e-e0e8-48e9-b1e8-56191f57ca33.png)
If brackets were not matched in the expression, the corresponding message will be displayed

![image](https://user-images.githubusercontent.com/66881230/164688047-48e3108a-a30e-4f24-87b9-8b60726d1617.png)
if the expression was entered incorrectly, the following message will appear

![image](https://user-images.githubusercontent.com/66881230/164688397-b63b043e-b1a5-4b2e-b8c1-c0c49729abb8.png)
You can view all expressions in the database, only correct expressions are stored in it. To edit, you need to click on the expression itself

![image](https://user-images.githubusercontent.com/66881230/164689065-bfb998c0-0c91-4392-b5a3-11640a018356.png)
when editing, an automatically entered expression will appear that can be changed, when changed, if it is correct, it will be saved to the database, if it is incorrect, an expression error will appear and will not be saved

![image](https://user-images.githubusercontent.com/66881230/164692001-0255404b-1e78-4d2e-ad60-c90a76778419.png)
the search for expressions and their results is implemented in one form. To search for a specific result, you need to enter the result you want to find, to search for a gap, you need to enter a gap with the corresponding sign ">" or "<"

![image](https://user-images.githubusercontent.com/66881230/164689961-a73cfbe4-6212-4946-b8b2-1b229152bf68.png)


