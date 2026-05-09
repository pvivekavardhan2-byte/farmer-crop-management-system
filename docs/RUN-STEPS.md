# Run Steps

## 1. Check Versions

```bash
java -version
mvn -v
node -v
npm -v
```

## 2. Start MySQL

Create database:

```sql
CREATE DATABASE farmer_crop_db;
```

## 3. Run Backend

```bash
cd backend-springboot
mvn clean install
mvn spring-boot:run
```

## 4. Run Frontend

```bash
cd frontend-angular
npm install
npm start
```

## 5. Open Browser

```text
http://localhost:4200
```
