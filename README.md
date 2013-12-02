# 淘淘网 爱淘淘 这处网 http://www.mogujie.com/

branch master->develop->test->release
test branck edit
release first

## host server
  mytt.cloudfoundry.com

## api service
  open.taobao.com

## spring mvc & JDBCTemplates & mybatis & JPA

### prerequisites
The following items should be installed in your system:
* Maven 3 (http://www.sonatype.com/books/mvnref-book/reference/installation.html)
* git command line tool (https://help.github.com/articles/set-up-git)
* Eclipse with the m2e plugin (m2e is installed by default when using the STS (http://www.springsource.org/sts) distribution of Eclipse)

Note: when m2e is available, there is an m2 icon in Help -> About dialog.
If m2e is not there, just follow the install process here: http://eclipse.org/m2e/download/

...submit test...

## Looking for something in particular?

<table>
  <tr>
    <th width="300px">Inside the 'Web' layer</th><th width="300px">Files</th>
  </tr>
  <tr>
    <td>Spring MVC- Atom integration</td>
    <td>
      <a href="/SpringSource/spring-petclinic/blob/master/src/main/java/org/springframework/samples/petclinic/web/VetsAtomView.java">VetsAtomView.java</a>
      <a href="/SpringSource/spring-petclinic/blob/master/src/main/resources/spring/mvc-view-config.xml">mvc-view-config.xml</a>
    </td>
  </tr>
  <tr>
    <td>Spring MVC - XML integration</td>
    <td><a href="/SpringSource/spring-petclinic/blob/master/src/main/resources/spring/mvc-view-config.xml">mvc-view-config.xml</a></td>
  </tr>
  <tr>
    <td>Spring MVC - ContentNegotiatingViewResolver</td>
    <td><a href="/SpringSource/spring-petclinic/blob/master/src/main/resources/spring/mvc-view-config.xml">mvc-view-config.xml</a></td>
  </tr>
  <tr>
    <td>Spring MVC Test Framework</td>
    <td><a href="/SpringSource/spring-petclinic/blob/master/src/test/java/org/springframework/samples/petclinic/web/VisitsViewTest.java">VisitsViewTest.java</a></td>
  </tr>
  <tr>
    <td>JSP custom tags</td>
    <td>
      <a href="/SpringSource/spring-petclinic/tree/master/src/main/webapp/WEB-INF/tags">WEB-INF/tags</a>
      <a href="/SpringSource/spring-petclinic/tree/master/src/main/webapp/WEB-INF/jsp/owners/createOrUpdateOwnerForm.jsp">createOrUpdateOwnerForm.jsp</a></td>
  </tr>
  <tr>
    <td>webjars</td>
    <td>
      <a href="/SpringSource/spring-petclinic/tree/master/pom.xml">webjars declaration inside pom.xml</a> <br />
      <a href="/SpringSource/spring-petclinic/blob/master/src/main/resources/spring/mvc-core-config.xml#L24">Resource mapping in Spring configuration</a> <br />
      <a href="/SpringSource/spring-petclinic/blob/master/src/main/webapp/WEB-INF/jsp/fragments/headTag.jsp#L12">sample usage in JSP</a></td>
    </td>
  </tr>
  <tr>
    <td>Dandelion-datatables</td>
    <td>
      <a href="/SpringSource/spring-petclinic/tree/master/src/main/webapp/WEB-INF/jsp/owners/ownersList.jsp">ownersList.jsp</a>
      <a href="/SpringSource/spring-petclinic/tree/master/src/main/webapp/WEB-INF/jsp/vets/vetList.jsp">vetList.jsp</a>
      <a href="/SpringSource/spring-petclinic/tree/master/src/main/webapp/WEB-INF/web.xml">web.xml</a>
   </td>
  </tr>
  <tr>
    <td>Thymeleaf branch</td>
    <td>
      <a href="http://www.thymeleaf.org/petclinic.html">See here</a></td>
  </tr>
  <tr>
    <td>Branch using GemFire and Spring Data GemFire instead of ehcache (thanks Bijoy Choudhury)</td>
    <td>
      <a href="https://github.com/bijoych/spring-petclinic-gemfire">See here</a></td>
  </tr>
</table>

<table>
  <tr>
    <th width="300px">'Service' and 'Repository' layers</th><th width="300px">Files</th>
  </tr>
  <tr>
    <td>Transactions</td>
    <td>
      <a href="/SpringSource/spring-petclinic/tree/master/src/main/resources/spring/business-config.xml">business-config.xml</a>
       <a href="/SpringSource/spring-petclinic/tree/master/src/main/java/org/springframework/samples/petclinic/service/ClinicServiceImpl.java">ClinicServiceImpl.java</a>
    </td>
  </tr>
  <tr>
    <td>Cache</td>
      <td>
      <a href="/SpringSource/spring-petclinic/tree/master/src/main/resources/spring/tools-config.xml">tools-config.xml</a>
       <a href="/SpringSource/spring-petclinic/tree/master/src/main/java/org/springframework/samples/petclinic/service/ClinicServiceImpl.java">ClinicServiceImpl.java</a>
    </td>
  </tr>
  <tr>
    <td>Bean Profiles</td>
      <td>
      <a href="/SpringSource/spring-petclinic/tree/master/src/main/resources/spring/business-config.xml">business-config.xml</a>
       <a href="/SpringSource/spring-petclinic/tree/master/src/test/java/org/springframework/samples/petclinic/service/ClinicServiceJdbcTests.java">ClinicServiceJdbcTests.java</a>
       <a href="/SpringSource/spring-petclinic/tree/master/src/main/webapp/WEB-INF/web.xml">web.xml</a>
    </td>
  </tr>
  <tr>
    <td>JdbcTemplate</td>
    <td>
      <a href="/SpringSource/spring-petclinic/tree/master/src/main/resources/spring/business-config.xml">business-config.xml</a>
      <a href="/SpringSource/spring-petclinic/tree/master/src/main/java/org/springframework/samples/petclinic/repository/jdbc">jdbc folder</a></td>
  </tr>
  <tr>
    <td>JPA</td>
    <td>
      <a href="/SpringSource/spring-petclinic/tree/master/src/main/resources/spring/business-config.xml">business-config.xml</a>
      <a href="/SpringSource/spring-petclinic/tree/master/src/main/java/org/springframework/samples/petclinic/repository/jpa">jpa folder</a></td>
  </tr>
  <tr>
    <td>Spring Data JPA</td>
    <td>
      <a href="/SpringSource/spring-petclinic/tree/master/src/main/resources/spring/business-config.xml">business-config.xml</a>
      <a href="/SpringSource/spring-petclinic/tree/master/src/main/java/org/springframework/samples/petclinic/repository/springdatajpa">springdatajpa folder</a></td>
  </tr>
</table>

<table>
  <tr>
    <th width="300px">Others</th><th width="300px">Files</th>
  </tr>
  <tr>
    <td>Gradle branch</td>
    <td>
      <a href="https://github.com/whimet/spring-petclinic">See here</a></td>
  </tr>
</table>


## Interaction with other open source projects

<table>
  <tr>
    <th width="300px">Name</th>
    <th width="300px"> Issue </th>
  </tr>

  <tr>
    <td>Spring JDBC: simplify usage of NamedParameterJdbcTemplate</td>
    <td> <a href="https://jira.springsource.org/browse/SPR-10256"> SPR-10256</a> and <a href="https://jira.springsource.org/browse/SPR-10257"> SPR-10257</a> </td>
  </tr>
  <tr>
    <td>Bean Validation / Hibernate Validator: simplify Maven dependencies and backward compatibility</td>
    <td>
      <a href="https://hibernate.atlassian.net/browse/HV-790"> HV-790</a> and <a href="https://hibernate.atlassian.net/browse/HV-792"> HV-792</a>
      </td>
  </tr>
  <tr>
    <td>Spring Data: provide more flexibility when working with JPQL queries</td>
    <td>
      <a href="https://jira.springsource.org/browse/DATAJPA-292"> DATAJPA-292</a>
      </td>
  </tr>
  <tr>
    <td>Eclipse: validation bug when working with .tag/.tagx files</td>
    <td>
      <a href="https://issuetracker.springsource.com/browse/STS-3294"> STS-3294</a>
    </td>
  </tr>
</table>
