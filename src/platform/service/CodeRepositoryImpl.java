package platform.service;

import org.springframework.stereotype.Service;
import platform.model.entity.Code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class CodeRepositoryImpl implements CodeRepository {
    List<Code> database = new ArrayList<>(10);

    @Override
    public Code getCodeById(long id) {
        return database.get((int) id - 1);
    }

    @Override
    public void putCode(Code code) {
        database.add(code);
    }

    @Override
    public List<Code> getLatestCode() {
        int fromIndex = database.size() < 10 ? 0 : database.size() - 10;
        List<Code> latestCode = new ArrayList<>(10);
        if (database.size() != 0) {
            latestCode.add(database.get(fromIndex));
            for (int i = fromIndex + 1; i < database.size(); i++) {
                latestCode.add(0, database.get(i));
            }
        }

        return latestCode;
    }
}
