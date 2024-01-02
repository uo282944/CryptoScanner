package org.ull.dap.modelo.persistence.seguimiento;

import org.ull.dap.modelo.persistence.Gateway;
import org.ull.dap.modelo.persistence.crypto.CryptoGateway.CryptoDALDto;
import org.ull.dap.modelo.persistence.user.UserGateway;

import java.util.List;
import java.util.Optional;

public interface SeguimientoGateway extends Gateway<SeguimientoGateway.SeguimientoDALDto> {
    List<CryptoDALDto> findCryptosById(String id);

    public class SeguimientoDALDto{
        public String id;
        public String id_usuario;
        public String id_crypto;
    }
}
