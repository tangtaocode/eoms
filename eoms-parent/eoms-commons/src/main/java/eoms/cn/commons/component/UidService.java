package eoms.cn.commons.component;

import com.robert.vesta.service.bean.Id;
import com.robert.vesta.service.intf.IdService;

public class UidService {
    private IdService idService;

    public UidService(IdService idService) {
        this.idService = idService;
    }
    /**
     * 生成id
     * @return
     */
    public long genId() {
        return idService.genId();
    }
    /**
     * 反解id
     * @param id
     * @return
     */
    public Id explainId(long id) {
        return idService.expId(id);
    }
    /**
     * 手工生成id
     * @param version
     * @param type
     * @param genMethod
     * @param machine
     * @param time
     * @param seq
     * @return
     */
    public long makeId(long version, long type, long genMethod, long machine, long time, long seq) {

        long madeId = -1;
        if (time == -1 || seq == -1)
            throw new IllegalArgumentException("Both time and seq are required.");
        else if (version == -1) {
            if (type == -1) {
                if (genMethod == -1) {
                    if (machine == -1) {
                        madeId = idService.makeId(time, seq);
                    } else {
                        madeId = idService.makeId(machine, time, seq);
                    }
                } else {
                    madeId = idService.makeId(genMethod, machine, time, seq);
                }
            } else {
                madeId = idService.makeId(type, genMethod, machine, time, seq);
            }
        } else {
            madeId = idService.makeId(version, type, genMethod, time, seq, machine);
        }

        return madeId;
    }
}
