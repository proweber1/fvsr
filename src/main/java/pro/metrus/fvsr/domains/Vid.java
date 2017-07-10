package pro.metrus.fvsr.domains;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Vid extends AbstractDictionary {

    @OneToOne
    private Vid parent;
}
