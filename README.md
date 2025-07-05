# Serq_login


```markdown
# 🔐 SERQ Login Automation (Selenium + TestNG + Maven)

This project automates login test scenarios for the [SERQ platform](https://user.serq.in/) https://provider.serq.in/auth using **Selenium WebDriver**, **TestNG**, and **Maven** with dynamic data and ExtentReports integration.

---

## 📌 Features

- ✅ Automated login tests for:
  - User portal: https://user.serq.in/
  - Provider portal: https://provider.serq.in/
- ✅ Data-driven testing using external `JSON` files
- ✅ Headless browser support for CI pipelines
- ✅ TestNG framework for execution and assertions
- ✅ ExtentReports with test logs and screenshots
- ✅ CI/CD integration with GitHub Actions
- ✅ Clean page object model (POM) structure

---

## 🧱 Technologies Used

| Tool         | Purpose                          |
|--------------|----------------------------------|
| Java         | Programming language             |
| Selenium     | Browser automation               |
| TestNG       | Test framework                   |
| Maven        | Dependency and build management  |
| Jackson      | JSON parsing for test data       |
| ExtentReports| Reporting & screenshots          |
| GitHub Actions | CI/CD pipeline                  |

---

## 📂 Folder Structure



Serq\_login/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── org/example/pages/
│   │           ├── BasePage.java
│   │           ├── UserLoginPage.java
│   │           └── ProviderLoginPage.java
│   ├── test/
│   │   ├── java/
│   │   │   └── com/example/tests/
│   │   │       ├── BaseTest.java
│   │   │       ├── UserLoginTest.java
│   │   │       └── ProviderLoginTest.java
│   │   └── resources/
│   │       ├── userData.json
│   │       └── providerData.json
├── reports/
│   └── ExtentReport.html
├── .github/
│   └── workflows/
│       └── ci.yml
├── pom.xml
└── README.md



---

## 📥 Setup Instructions

1. **Clone the repo**  
   ```bash
   git clone https://github.com/<your-username>/Serq_login.git
   cd Serq_login
````

2. **Install dependencies**
   Maven will auto-install required libraries via `pom.xml`.

3. **Run Tests**

   ```bash
   mvn clean test
   ```

4. **View Reports**
   Open `reports/ExtentReport.html` in a browser after test execution.

---

## 📄 JSON Test Data Files

`userData.json` and `providerData.json` contain credentials and URLs:

```json
{
  "url": "https://user.serq.in/auth",
  "username": "9931589733",
  "password": "123456789",
  "expectedTitle": "SERQ"
}
```

---

## 🧪 Test Scenarios Covered

* ✅ Valid login
* ❌ Invalid login (wrong/missing credentials)
* 🔁 Session timeout
* 🧭 UI validations (title, button states, placeholders)
* 🧾 Title-based assertion post-login

---

## 🧪 How Headless Mode is Configured

```java
ChromeOptions options = new ChromeOptions();
options.addArguments("--headless=new", "--no-sandbox", "--disable-dev-shm-usage");
```

---

## 🧰 CI/CD via GitHub Actions

* Runs `mvn clean test` on push
* Fails pipeline if any test fails
* Can be enhanced to upload screenshots on failure

---

## 📸 Screenshot on Test Failure

Integrated with ExtentReports using `ITestResult` in `BaseTest.java`. Screenshots are captured on failure and attached to reports.

---

## 🤝 Contributing

Feel free to fork and submit PRs. For improvements or issues, raise a GitHub Issue.

---

## 🔐 Disclaimer

Test credentials used here are for automation demo purposes only and should not be used for production environments.

```

