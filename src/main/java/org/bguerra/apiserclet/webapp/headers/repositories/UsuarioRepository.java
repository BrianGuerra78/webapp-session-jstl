package org.bguerra.apiserclet.webapp.headers.repositories;

import org.bguerra.apiserclet.webapp.headers.models.Usuario;

import java.sql.SQLException;

public interface UsuarioRepository extends Repository<Usuario> {
    Usuario porUsername(String username) throws SQLException;
}
