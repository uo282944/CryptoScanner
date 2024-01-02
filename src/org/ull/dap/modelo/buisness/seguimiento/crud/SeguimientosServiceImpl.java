package org.ull.dap.modelo.buisness.seguimiento.crud;

import org.ull.dap.modelo.BusinessException;
import org.ull.dap.modelo.buisness.crypto.CryptosService;
import org.ull.dap.modelo.buisness.seguimiento.SeguimientosService;
import org.ull.dap.modelo.buisness.seguimiento.crud.commands.AddSeguimientoTS;
import org.ull.dap.modelo.buisness.seguimiento.crud.commands.FindCryptosByIdTS;
import org.ull.dap.modelo.buisness.util.CommandExecutor;

import java.util.List;

public class SeguimientosServiceImpl implements SeguimientosService {


    @Override
    public SeguimientoBLDto addSeguimiento(SeguimientoBLDto seg) throws BusinessException {
        return new CommandExecutor().execute(new AddSeguimientoTS(seg));
    }
    @Override
    public List<CryptosService.CryptoBLDto> findCryptosById(String idUsuario) throws BusinessException {
        return new CommandExecutor().execute(new FindCryptosByIdTS(idUsuario));
    }
}