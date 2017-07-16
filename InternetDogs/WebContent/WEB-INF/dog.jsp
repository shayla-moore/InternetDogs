<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 
<title>Add New Dog</title>
</head>
<body>
    <form action="DogController.do" method="post">
        <fieldset>
            <div>
                <label for="dog_id">Dog ID</label> <input type="text"
                    name="dog_id" value="<c:out value="${dog.dog_id}" />"
                    readonly="readonly" placeholder="Dog ID" />
            </div>
            <div>
                <label for="dname">Dog Name</label> <input type="text"
                    name="dname" value="<c:out value="${dog.dname}" />"
                    placeholder="Dog_Name" />
            </div>
            <div>
                <label for="breed">Breed</label> <input type="text"
                    name="breed" value="<c:out value="${dog.breed}" />"
                    placeholder="Breed" />
            </div>
            <div>
                <label for="age">Age</label> <input type="text" name="age"
                    value="<c:out value="${dog.age}" />" placeholder="Age" />
            </div>
            <div>
                <label for="birthday">Birthday</label> <input type="text" name="birthday"
                    value="<c:out value="${dog.birthday}" />" placeholder="Birthday" />
            </div>
             <div>
                <label for="owner_name">Owner Name</label> <input type="text" name="owner_name"
                    value="<c:out value="${dog.owner_name}" />" placeholder="Owner_Name" />
            </div>
            <div>
                <input type="submit" value="Submit" />
            </div>
        </fieldset>
    </form>
</body>
</html>