Mediscreen


### Récupérer tous les patients
- **URL**: `/patients`
- **Méthode**: `GET`
- **Paramètres d'URL**: Aucun
- **Réponse (réussite)**:
  - **Code**: 200
  - **Contenu**: Liste de patients
- **Exemple d'appel**: `curl http://localhost:8081/patients`

### Ajouter un patient
- **URL**: `/patient/add`
- **Méthode**: `POST`
- **Paramètres de données**:
  - JSON du patient à ajouter
- **Réponse (réussite)**:
  - **Code**: 201
  - **Contenu**: Patient créé
- **Exemple d'appel**: `curl -X POST -H "Content-Type: application/json" -d '{"name": "John", "age": 30}' http://localhost:8081/patient/add`

### Mettre à jour un patient
- **URL**: `/updatePatient/{id}`
- **Méthode**: `PUT`
- **Paramètres d'URL**:
  - **Obligatoires**: `id` = ID du patient
- **Paramètres de données**:
  - JSON du patient à mettre à jour
- **Réponse (réussite)**:
  - **Code**: 202
  - **Contenu**: Patient mis à jour
- **Exemple d'appel**: `curl -X PUT -H "Content-Type: application/json" -d '{"name": "John Updated", "age": 31}' http://localhost:8081/updatePatient/1`

### Supprimer un patient
- **URL**: `/deletePatient/{id}`
- **Méthode**: `POST`
- **Paramètres d'URL**:
  - **Obligatoires**: `id` = ID du patient
- **Réponse (réussite)**:
  - **Code**: 204
  - **Contenu**: Aucun
- **Exemple d'appel**: `curl -X POST http://localhost:8081/deletePatient/1`

### Ajouter une note
- **URL**: `/patHistory/add`
- **Méthode**: `POST`
- **Paramètres d'URL**:
  - **Obligatoires**: `patId` = ID du patient, `note` = Note à ajouter
- **Réponse (réussite)**:
  - **Code**: 200
  - **Contenu**: "Note added successfully"
- **Exemple d'appel**: `curl -X POST -d 'patId=1&note=NoteTextHere' http://localhost:8082/patHistory/add`

### Obtenir l'historique du patient
- **URL**: `/patHistory/{patId}`
- **Méthode**: `GET`
- **Paramètres d'URL**:
  - **Obligatoires**: `patId` = ID du patient
- **Réponse (réussite)**:
  - **Code**: 200
  - **Contenu**: Liste des notes du patient
- **Exemple d'appel**: `curl http://localhost:8082/patHistory/1`

### Mettre à jour une note
- **URL**: `/patHistory/update/{noteId}`
- **Méthode**: `PUT`
- **Paramètres d'URL**:
  - **Obligatoires**: `noteId` = ID de la note, `note` = Nouvelle note
- **Réponse (réussite)**:
  - **Code**: 200
  - **Contenu**: "Note updated successfully"
- **Réponse (échec)**:
  - **Code**: 400
  - **Contenu**: "An error occurred while updating the note"
- **Exemple d'appel**: `curl -X PUT -d 'note=UpdatedNoteTextHere' http://localhost:8082/patHistory/update/64e36fe662deb05955dbc405	`

### Supprimer une note
- **URL**: `/patHistory/delete/{noteId}`
- **Méthode**: `POST`
- **Paramètres d'URL**:
  - **Obligatoires**: `noteId` = ID de la note
- **Réponse (réussite)**:
  - **Code**: 200
  - **Contenu**: "Note deleted successfully"
- **Réponse (échec)**:
  - **Code**: 400
  - **Contenu**: "An error occurred while deleting the note"
- **Exemple d'appel**: `curl -X POST http://localhost:8082/patHistory/delete/64e36fe662deb05955dbc405`


