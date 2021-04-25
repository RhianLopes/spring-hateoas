# spring-hateoas

## Contexto

Este repositório tem como objetivo guardar e documentar o conhecimento adquirido ao pesquisar mais sobre [Spring Hateoas](https://spring.io/projects/spring-hateoas), inicialmente os conteúdos desse repositório serão apresentados nas reuniões de padrões internas do time no qual participo.

## Introdução

O [Spring Hateoas](https://spring.io/projects/spring-hateoas) permite que criemos [hiperlinks](https://developer.mozilla.org/pt-BR/docs/Learn/Common_questions/What_are_hyperlinks) que permitem que transitemos entre os endpoints permitidos da API, sem a necessidade de conhecermos as regras de negócio, somente seguindo as opção disponibilizadas de hiperlink da API.

## Criando seu projeto com Spring Hateoas

Para criar seu primeiro projeto utilizando Spring Hateoas, você pode criar um simples projeto via [Spring Initializr](https://start.spring.io/) ou utilizar algum projeto Spring já existente.

Para começar a utilizar as funções do Spring Hateoas, basta adicionar no arquivo `pom.xml` de seu projeto a dependência do Spring Hateoas abaixo:

```xml
<dependency>
  <groupId>org.springframework.hateoas</groupId>
  <artifactId>spring-hateoas</artifactId>
  <version>1.1.5.RELEASE</version>
</dependency>
```

Feito isso, basta rodar seu projeto e o mesmo poderá usufruir de todas as funções do Spring Hateoas.

