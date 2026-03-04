# Dokumentasi API - Praktikum 1 CRUD

## Dokumentasi API (Endpoints)

### 1. Create User
- **Method**: `POST`
- **URL**: `/api/users`
- **Status**: `201 Created`
- **Request Body**:
  ```json
  {
    "name": "Budi Santoso",
    "age": 23
  }
  ```
- **Output**:
  ```json
  {
    "status": "success",
    "data": {
      "id": "1eb214e2-962e-4528-a9de-28522df1a37e",
      "name": "Budi Santoso",
      "age": 23
    }
  }
  ```

---

### 2. Get All User
- **Method**: `GET`
- **URL**: `/api/users`
- **Status**: `200 OK`
- **Output**:
  ```json
  {
    "status": "success",
    "data": [
      {
        "id": "1eb214e2-962e-4528-a9de-28522df1a37e",
        "name": "Budi Santoso",
        "age": 23
      }
    ]
  }
  ```

---

### 3. Get User By ID
- **Method**: `GET`
- **URL**: `/api/users/{id}`

- **Status**: `200 OK`
- **Output**:
  ```json
  {
    "status": "success",
    "data": {
      "id": "1eb214e2-962e-4528-a9de-28522df1a37e",
      "name": "Budi Santoso",
      "age": 23
    }
  }
  ```

---

### 4. Update User
- **Method**: `PUT`
- **URL**: `/api/users/{id}`
- **Status**: `200 OK`
- **Request Body**:
  ```json
  {
    "name": "Budi Terupdate",
    "age": 22
  }
  ```
- **Output**:
  ```json
  {
    "status": "success",
    "data": {
      "id": "1eb214e2-962e-4528-a9de-28522df1a37e",
      "name": "Budi Terupdate",
      "age": 22
    }
  }
  ```

---

### 5. Delete User
- **Method**: `DELETE`
- **URL**: `/api/users/{id}`
- **Status**: `200 OK`
- **Output**:
  ```json
  {
    "status": "success",
    "data": "success delete user with id 1eb214e2-962e-4528-a9de-28522df1a37e"
  }
  ```

  ### Tampilan 
  <img width="1919" height="952" alt="image" src="https://github.com/user-attachments/assets/497c9d03-86e9-4974-88c0-6999f0a86ffd" />


