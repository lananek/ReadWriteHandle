
<img src="https://user-images.githubusercontent.com/116422832/212487834-5b6b055d-83ef-46db-8b3f-4db1fa89fd8f.png" height="400"> 

# Сквозная задача
Необходимо реализовать консольное приложение, которое:
+ Читает данные из входного файла;
+ Обрабатывает полученную информацию;
+ Записывает данные в выходной файл;

Входной и выходной файл могут быть следующих форматов: plain text, xml, json. Так же входные и выходные файлы могут быть архивированы и зашифрованы (только архивирован, только зашифрован, сперва архивирован, а потом зашифрован и наоборот).

«Тип» входного и выходного файла задаются параметрами консоли.
Приложение реализовать двумя способами: без использования Design Patterns и c использованием Design Patterns (Decorator и Builder … можно оформить Builder в виде Singleton-а), сравнить реализации.

Обработка информации на первом этапе: найти все арифметические операции во входном файле и заменить на результаты в выходном файле.
Реализовать фильтрацию двумя способами без использования регулярных выражений и с использованием регулярных выражений. Провести сравнительный анализ 2-х вариантов реализации.

## Атомарные задачи 

:white_check_mark: Чтение \ запись текстовый файл;    
:white_check_mark: Чтение \ запись xml файл (используя специальный API для чтения XML и не используя – чтение по строчно);    
:white_check_mark: Чтение \ запись json файл (используя специальный API для чтения XML и не используя – чтение по строчно);    
:white_check_mark: Архивация \ де Архивация файла используя ту или иную реализацию Zip;    
:white_check_mark: Архивация \ де Архивация файла используя ту или иную реализацию Rar;    
:white_check_mark: Шифровка \ де Шифровка файла используя любую библиотеку шифрования;   
:white_check_mark: Покрыть все эти атомарные задачи Unit Test-ами;   
