# API Documentation for Mediscreen

## Patients

### Get All Patients
- **URL**: `/patients`
- **Method**: `GET`
- **URL Parameters**: None
- **Response (Success)**:
  - **Code**: 200
  - **Content**: List of patients
- **Example Call**: `curl http://localhost:8081/patients`

### Add a Patient
- **URL**: `/patient/add`
- **Method**: `POST`
- **Data Parameters**:
  - JSON object representing the patient to add
- **Response (Success)**:
  - **Code**: 201
  - **Content**: Created patient
- **Example Call**: `curl -X POST -H "Content-Type: application/json" -d '{"name": "John", "age": 30}' http://localhost:8081/patient/add`

### Update a Patient
- **URL**: `/updatePatient/{id}`
- **Method**: `PUT`
- **URL Parameters**:
  - **Required**: `id` = Patient ID
- **Data Parameters**:
  - JSON object representing the patient to update
- **Response (Success)**:
  - **Code**: 202
  - **Content**: Updated patient
- **Example Call**: `curl -X PUT -H "Content-Type: application/json" -d '{"name": "John Updated", "age": 31}' http://localhost:8081/updatePatient/1`

### Delete a Patient
- **URL**: `/deletePatient/{id}`
- **Method**: `POST`
- **URL Parameters**:
  - **Required**: `id` = Patient ID
- **Response (Success)**:
  - **Code**: 204
  - **Content**: No content
- **Example Call**: `curl -X POST http://localhost:8081/deletePatient/1`

## Patient Notes

### Add a Note
- **URL**: `/patHistory/add`
- **Method**: `POST`
- **URL Parameters**:
  - **Required**: `patId` = Patient ID, `note` = Note to add
- **Response (Success)**:
  - **Code**: 200
  - **Content**: "Note added successfully"
- **Example Call**: `curl -X POST -d 'patId=1&note=NoteTextHere' http://localhost:8082/patHistory/add`

### Get Patient History
- **URL**: `/patHistory/{patId}`
- **Method**: `GET`
- **URL Parameters**:
  - **Required**: `patId` = Patient ID
- **Response (Success)**:
  - **Code**: 200
  - **Content**: List of patient notes
- **Example Call**: `curl http://localhost:8082/patHistory/1`

### Update a Note
- **URL**: `/patHistory/update/{noteId}`
- **Method**: `PUT`
- **URL Parameters**:
  - **Required**: `noteId` = Note ID
- **Data Parameters**:
  - `note` = New note content
- **Response (Success)**:
  - **Code**: 200
  - **Content**: "Note updated successfully"
- **Response (Failure)**:
  - **Code**: 400
  - **Content**: "An error occurred while updating the note"
- **Example Call**: `curl -X PUT -d 'note=UpdatedNoteTextHere' http://localhost:8082/patHistory/update/64e36fe662deb05955dbc405`

### Delete a Note
- **URL**: `/patHistory/delete/{noteId}`
- **Method**: `POST`
- **URL Parameters**:
  - **Required**: `noteId` = Note ID
- **Response (Success)**:
  - **Code**: 200
  - **Content**: "Note deleted successfully"
- **Response (Failure)**:
  - **Code**: 400
  - **Content**: "An error occurred while deleting the note"
- **Example Call**: `curl -X POST http://localhost:8082/patHistory/delete/64e36fe662deb05955dbc405`

## Diabetes Assessment

### Assess Patient by ID
- **URL**: `/assess/id`
- **Method**: `POST`
- **Data Parameters**:
  - `patId` = Patient ID
- **Response (Success)**:
  - **Code**: 200
  - **Content**: Assessment result for the patient
- **Example Call**: `curl -d "patId=1" -X POST http://localhost:8080/assess/id`

### Assess Patient by Family Name
- **URL**: `/assess/familyName`
- **Method**: `POST`
- **Data Parameters**:
  - `familyName` = Family name of the patients to assess
- **Response (Success)**:
  - **Code**: 200
  - **Content**: Assessment results for patients with the given family name
- **Example Call**: `curl -d "familyName=Smith" -X POST http://localhost:8080/assess/familyName`
