# PlanViewer

This Android app acts as a simple timetable utilizing Room persistence ORM.<br><br>
It allows the user to add items at a selected hour on a selected date and display the DB entries.<br>
The entries can also be filtered by day of the week to display each day separately. 
<br>
<h3>Class description</h3>
There are two activities:<br>
-MainActivity - where the elements are displayed<br>
-AddItemActivity - which enables the user to create entries<br>
<br>
The domain consists of a single class - <b>PlanItem</b>. It is used by Room to create a table in the DB.
<br>
The data is retrieved from DB using <b>PlanItemDao</b> and the DB itself is established in <b>AppDatabase</b> and <b>DatabaseInit</b> classes.
<br><br>
<b>MyDbHelper</b> class provides easy access to the database by providing a set of static methods.
<br>
<b>PlanItemAdapter</b> is an adapter class used for populating the listView with items from the DB.
<br>


