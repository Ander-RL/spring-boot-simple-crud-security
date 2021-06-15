<h1>Simple Spring CRUD example</h1>
<h2>End Points</h2>
<ul>
<h4>Create (Post)</h4>
<h6>@RequestBody EntityInputDTO</h6>
    localhost:8080/api/entity/
<hr/>
<h4>Delete (Delete)</h4>
<h6>@PathVariable("id")</h6>
    localhost:8080/api/entity/{id}
<hr/>
<h4>FindById (Get)</h4>
<h6>@PathVariable("id")</h6>
    localhost:8080/api/entity/{id}
<hr/>
<h4>GetAll (Get)</h4>
    localhost:8080/api/entity/
<hr/>
<h4>Search (Post)</h4>
<h6>@RequestBody EntityInputDTO</h6>
    localhost:8080/api/entity/search
<hr/>
<h4>Update (Put)</h4>
<h6>@RequestBody EntityInputDTO, @PathVariable("id")</h6>
    localhost:8080/api/entity/
<hr/>
</ul>
<h2>Entities</h2>
<ul>
    <li>materia</li>
    <li>nota</li>
    <li>persona</li>
    <li>student</li>
    <li>study</li>
    <li>tiporegistro</li>
</ul>
<h2>Security</h2>
<h4>Spring Security</h4>
<h4>JWT</h4>
<h2>Data Base</h2>
<h4>Postgres SQL & H2</h4>
<h2>Swagger 2</h2>
<h4>localhost:8080/swagger-ui.html</h4>