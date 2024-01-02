package org.ull.dap.modelo.buisness.seguimiento;

import org.ull.dap.modelo.BusinessException;
import org.ull.dap.modelo.buisness.crypto.CryptosService.CryptoBLDto;
import org.ull.dap.modelo.buisness.user.UsersService.UserBLDto;

import java.util.List;
import java.util.Optional;

public interface SeguimientosService {
    SeguimientoBLDto addSeguimiento(SeguimientoBLDto seg) throws BusinessException;
    List<CryptoBLDto> findCryptosById(String idUsuario) throws BusinessException;

    public class SeguimientoBLDto {

        public String id;
        public String id_usuario;
        public String id_crypto;
    }
}
