package br.com.rabbitbank.rabbitbank.resource.swaggr;

import br.com.rabbitbank.rabbitbank.dto.ErrorDTO;
import br.com.rabbitbank.rabbitbank.dto.UserDTO;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface IUserResource {
    @ApiOperation(value = "Consultar saldo de um usuário por login", nickname = "consultBalance", notes = "", response = UserDTO.class, responseContainer = "object", authorizations = {
            @Authorization(value = "Authorization") }, tags = { "usuarios" })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Saldo consultado com sucesso", response = UserDTO.class, responseContainer = "object"),
            @ApiResponse(code = 400, message = "Dados informados para a requisição estão inconsistentes", response = ErrorDTO.class, responseContainer = "object"),
            @ApiResponse(code = 401, message = "Usuário sem permissão para acessar o recurso"),
            @ApiResponse(code = 404, message = "Usuário não encontrado") })
    @GetMapping("/{login}/saldo")
    public ResponseEntity<UserDTO> consultBalance(@PageableDefault(page = 0, size = 20) Pageable pagination,
                                                     @PathVariable String login);

    @ApiOperation(value = "Consultar contatos de um usuário por login", nickname = "listarContatos", notes = "", response = UserDTO.class, responseContainer = "object", authorizations = {
            @Authorization(value = "basicAuth") }, tags = { "usuarios", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Contatos encontrado com sucesso", response = UserDTO.class, responseContainer = "object"),
            @ApiResponse(code = 400, message = "Dados informados para a requisição estão inconsistentes", response = ErrorDTO.class, responseContainer = "object"),
            @ApiResponse(code = 401, message = "Usuário sem permissão para acessar o recurso"),
            @ApiResponse(code = 404, message = "Usuário não encontrado") })
    @GetMapping("/contatos")
    public ResponseEntity<List<UserDTO>> lists(@RequestParam String login);

    @ApiOperation(value = "Consultar usuário por login", nickname = "consultarUsuarios", notes = "", response = UserDTO.class, responseContainer = "object", authorizations = {
            @Authorization(value = "basicAuth") }, tags = { "usuarios", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Usuário encontrado com sucesso", response = UserDTO.class, responseContainer = "object"),
            @ApiResponse(code = 400, message = "Dados informados para a requisição estão inconsistentes", response = ErrorDTO.class, responseContainer = "object"),
            @ApiResponse(code = 401, message = "Usuário sem permissão para acessar o recurso"),
            @ApiResponse(code = 404, message = "Usuário não encontrada") })
    @GetMapping("/{login}")
    public ResponseEntity<UserDTO> consult(@PathVariable String login);
}
