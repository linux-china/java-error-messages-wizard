Java Error Messages Wizard - Write Good Error Message
======================================================

# Features

* Error Code Design
* Standard Error Message Format
* Resource Bundle: properties file and i18n
* slf4j friendly
* IntelliJ IDEA friendly

# Error Code Design

Error code a unique string value for a kind of error, and includes 3 parts:

* System/App short name: such as RST, APP1. Yes, Jira alike
* Component short name or code: such as LOGIN, 001
* Status code: a 3 digital number to describe error's status, such as 404, 500. Reference from HTTP Status Code.

Error Code examples:

* OSS-001-404
* RST-002-500
* UIC-LOGIN-500

# Error Message

A good error message with following parts:

* Context: What led to the error? What was the code trying to do when it failed? where?
* The error itself: What exactly failed? description and reason
* Mitigation: What needs to be done in order to overcome the error? Solutions

Fields for an error:

* context: such as app name, component, status code
* description: Long(Short) to describe error
* because/reason:  explain the reason with data
* documentedAt: error link
* solutions: possible solutions

Message format for an error: `long description(short desc): because/reason --- document link -- solutions`

# Use properties file to save error code and message

Example as following:

```properties   
ERROR-CODE: long description(short desc): because/reason --- document link -- solutions
RST-100400=Failed to log in system with email and password(Email login failed): can not find account with email {0} --- please refer https://example.com/login/byemail  --- Solutions: 1. check your email  2. check your password
RST-100401=Failed to log in system with phone and pass(Phone login failed): can not find account with phone {0} --- please refer https://example.com/login/byphone  --- Solutions: 1. check your phone  2. check your pass code in SMS
```

# FAQ

### Why Choose HTTP Status Code as Error status code?

Most developers know HTTP status code: 200, 404, 500

* Informational responses (100–199)
* Successful responses (200–299)
* Redirection messages (300–399)
* Client error responses (400–499)
* Server error responses (500–599)

### Why Choose properties file to store error messages?

Properties file is friendly for i18n and IDE friendly now

* Code completion support for error code
* Error Code rename support
* Quick view support
* MessageFormat support
* Resource Bundle for i18n support

Yes, you can choose Enum and POJO class, but some complication.

If you use Rust, and Enum is good choice, for example `thiserror` + `error-stack` :

```rust
use thiserror::Error as ThisError;

/// errors for config component: app-100
#[derive(ThisError, Debug)]
pub enum ConfigError {
    #[error("APP-100404: config file not found: {0}")]
    NotFound(String),
    #[error("APP-100422: invalid JSON Format: {0}")]
    Invalid(String),
}

fn parse_config() -> Result<ConfigMap, ConfigError> {
    let json_file = "config.json";
    let config = std::fs::read_to_string(json_file)
        .report()
        .change_context(ConfigError::NotFound(json_file.to_string()))?;
    let map: ConfigMap = serde_json::from_str(&config)
        .report()
        .change_context(ConfigError::Invalid(json_file.to_string()))?;
    Ok(map)
}
```

For more error code design with Rust, please visit https://github.com/linux-china/rust-error-messages-wizard

# References

* What's in a Good Error Message?  https://www.morling.dev/blog/whats-in-a-good-error-message/
* jdoctor:  https://github.com/melix/jdoctor
* HTTP response status codes: https://developer.mozilla.org/en-US/docs/Web/HTTP/Status
* HTTP Status cheatsheet: https://devhints.io/http-status
* @PropertyKey support for slf4j message format - https://youtrack.jetbrains.com/issue/IDEA-286726
* @PrintFormat: annotation to printf-like methods - https://youtrack.jetbrains.com/issue/IDEA-283556
