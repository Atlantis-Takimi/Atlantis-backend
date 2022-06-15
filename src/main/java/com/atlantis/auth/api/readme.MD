Spring Boot ve Güvenlik
-
- Spring Boot, güvenlik ihtiyaçlarını karşılamak için Spring
Security Framework’ü kullanmaktadır
- Spring Security web uygulamaları için kimliklendirme ve
yetkilendirme kabiliyetleri sunan kapsamlı bir güvenlik
framework’üdür

Default Ayarlar
- Bütün HTTP endpoint'leri güvenlik altına alınmıştır
- Kullanıcı adı user olan, password'ü rastgele
  belirlenmiş ve lNFO log düzeyinde console'a yazılan bir
  kullanıcı mevcuttur
- Default kullanıcı adını, password'ü ve rollerini değiştirmek
  mümkündür
- CSRF, XSS, HSTS gibi özellikler devrededir

Aşağıdaki statik web resource path'leri public resource
  olarak erişilmektedir:

- /css/**
- /js/**
- /images/**
- /webjars/**
- /**/favicon.ico

Security kısmında yapılanlar:
-
- Dependency'ler arasına spring security gereksinimleri tanımlandı
- Proje run edildi ve orada default olarak üretilen password'ü kopyalayıp "http://localhost:8080/" adresinde bulunan giriş ekranına yazılarak owner'lar listelendi.
- Web konfigürasyonları sağlandı.