package org.csu.mypetstore.persistence;

import org.csu.mypetstore.domain.Sequence;
import org.springframework.stereotype.Repository;

@Repository
public interface SequenceMapper {
    //获取序列
    Sequence getSequence(Sequence sequence);

    //更新序列
    void updateSequence(Sequence sequence);
}
