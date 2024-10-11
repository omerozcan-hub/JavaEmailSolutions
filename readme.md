# Java E-posta Gönderim

Bu proje, Spring Framework ve Java kullanarak e-posta göndermek için çeşitli yöntemleri içermektedir. Farklı yöntemleri keşfetmek ve uygulamak amacıyla bir araya getirilmiştir.

## İçindekiler

- [Proje Hakkında](#proje-hakkında)
- [Kurulum](#kurulum)
- [Kullanılan Yöntemler](#kullanılan-yöntemler)
- [Kullanılan Kütüphaneler](#kullanılan-kütüphaneler)


## Proje Hakkında

Bu proje, farklı e-posta gönderim yöntemlerini uygulamak için bir referans olarak tasarlanmıştır. Projede aşağıdaki yöntemler bulunmaktadır:

- **Spring Boot Starter Mail**: Temel e-posta gönderimi.
- **MimeMessage ile Zengin İçerikli E-posta Gönderme**: HTML ve dosya ekleri içeren e-postalar.
- **Async E-mail Gönderimi**: Asenkron olarak e-posta gönderimi.
- **Spring Integration ile**: Daha karmaşık e-posta akışları.
- **Third-Party Libraries ile Entegrasyon**: Örneğin, AWS SES veya SendGrid ile e-posta gönderimi.
- **Templating Motorları (thymeleaf) ile Mail Gönderimi**: Dinamik içerik oluşturma.

## Kurulum

1. Projeyi klonlayın:
```bash
   git clone <repo-url>
```

2. Gerekli bağımlılıkları yüklemek için Maven kullanın:
```bash
   mvn clean install
```


3. `application.properties` dosyasında SMTP ayarlarını yapılandırın.

## Kullanılan Yöntemler

### 1. Spring Boot Starter Mail
- **Açıklama**: Basit e-posta gönderimi için kullanılır.
- **Örnek Kod**: [Kod bağlantısı](JavaMailSender)

### 2. MimeMessage ile Zengin İçerikli E-posta
- **Açıklama**: HTML içerikli e-posta gönderimi için kullanılır.
- **Örnek Kod**: [Kod bağlantısı](MimeMessageMail)

### 3. Async E-mail Gönderimi
- **Açıklama**: E-posta gönderimini asenkron hale getirir.
- **Örnek Kod**: [Kod bağlantısı](AsyncMail)

### 4. Spring Integration
- **Açıklama**: Karmaşık e-posta akışları yönetimi.
- **Örnek Kod**: [Kod bağlantısı](IntegrationMail)

### 5. Third-Party Libraries
- **Açıklama**: SendGrid, AWS SES gibi kütüphanelerle e-posta gönderimi.
- **Örnek Kod**: [Kod bağlantısı](ApacheCommonsEmail)

### 6. Templating Motorları ile Mail
- **Açıklama**: Dinamik içerikli e-posta gönderimi.
- **Örnek Kod**: [Kod bağlantısı](ThymeleafMail)

### 7. Direct SMTP ile Mail
- **Açıklama**: Doğrudan SMTP isteği ile. Spring kullanmadan
- **Örnek Kod**: [Kod bağlantısı](DirectSMTP)
- 
## Kullanılan Kütüphaneler

- Spring Boot
- JavaMail
- Thymeleaf (veya diğer templating motorları)
- Apache commons


