# Spring Boot REST API

Simple API built with Spring Boot that connects to a MySQL database using Spring Data JPA

## Features

- Create employee
- List all employees
- Fetch single employee by id
- Update employee by id
- Delete employee by id

## Demo

### Get all employees

```http
  GET /api/v1/employees/all-employees
```

#### Sample Response

```json
[
    {
        "id": 1,
        "firstName": "Nguyen Tran Anh",
        "lastName": "Dung",
        "email": "dung@gmai.com"
    },
    {
        "id": 2,
        "firstName": "Join",
        "lastName": "Cena",
        "email": "cena@gmai.com"
    }
]
```

### Get single employee

```http
  GET /api/v1/employees/get-employee/${id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `long` | **Required**. Id of employee to fetch |

#### Sample Response

```json
{
    "id": 2,
    "firstName": "Join",
    "lastName": "Cena",
    "email": "cena@gmai.com"
}
```

### Save employee

```http
  POST /api/v1/employees/save-employee
```
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `employee reference`      | `Employee` | **Required**. Request body of employee |

#### Sample Request

```json
{
    "firstName": "David",
    "lastName": "Beckham",
    "email": "beckham@gmail.com"
}
```

### Update employee

```http
  PUT /api/v1/employees/update-employee/${id}
```
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `long` | **Required**. Id of employee to update |
| `employee reference`      | `Employee` | **Required**. Request body of employee |

#### Sample Request

```json
{
    "firstName": "Travis",
    "lastName": "Scott",
    "email": "scott@gmai.com"
}
```

### Delete employee

```http
  DELETE /api/v1/employees/delete-employee/${id}
```
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `long` | **Required**. Id of employee to delete |

#### Message Response

```text
Employee with ID: 4 deleted successfully!
```
