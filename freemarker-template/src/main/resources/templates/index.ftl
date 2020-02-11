<html>
<title>Student List</title>
<meta charset="utf-8" />
<body>
<h3>Student Grade Table</h3>
<table>
    <tr>
        <th>Student ID</th>
        <th>Student Name</th>
        <th>Grade</th>
    </tr>
    <#list model["customers"] as customer>
        <tr>
            <th scope="row">${customer.customerId}</th>
            <td>${customer.customerName}</td>
            <td>${customer.email}</td>
            <td>${customer.dateOfBirth}</td>
            <td><a class="btn btn-sm btn-warning" role="button"
                   href="/delete/${customer.customerId}">Delete</a></td>
        </tr>
    </#list>
</table>
</body>
</html>
