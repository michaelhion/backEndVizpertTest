# backEndVizpertTest

Aplicação em java com spring boot rest api<br/>
Contém os metodos de crud para inserir informações de livros<br/>
Utiliza o banco de dados postgresql<br/>

##Tarefas pendentes<br/>
- [ ] Fazer testes unitários<br/>
- [ ] Tratamento de erros<br/>
- [ ] Criar imagem com docker compose<br/>

##EndPoints
/swagger-ui -interface para testes
/bookApi/listar -retorna um json com a lista de livros persistidos no db
/bookApi/adicionar - adiciona um json 
/bookApi/listarPorId/{id} - retorna um json com um livro específico selecionado pelo id
/bookApi/book/{id} - deleta o livro selecionado pelo id
/bookApi/book/{id} - deleta o livro selecionado pelo id

