<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show All Dogs</title>
</head>
<body>
    <table>
        <thead>
            <tr>
                <th>Dog ID</th>
                <th>Dog Name</th>
                <th>Breed</th>
                <th>Age</th>
                <th>Birthday</th>
                <th>Owner Name</th>
                <th colspan="2">Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${dogs}" var="dog">
                <tr>
                    <td><c:out value="${dog.dog_id}" /></td>
                    <td><c:out value="${dog.dname}" /></td>
                    <td><c:out value="${dog.breed}" /></td>
                    <td><c:out value="${dog.age}" /></td>
                    <td><c:out value="${dog.birthday}" /></td>
                    <td><c:out value="${dog.owner_name}" /></td>
                    <td><a
                        href="DogController.do?action=edit&dog_id=<c:out value="${dog.dog_id }"/>">Update</a></td>
                    <td><a
                        href="DogController.do?action=delete&dog_id=<c:out value="${dog.dog_id }"/>">Delete</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <p>
        <a href="DogController.do?action=insert">Add Dog</a>
    </p>
</body>
</html>