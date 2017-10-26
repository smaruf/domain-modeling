package main.modeling102.service.impl;

import main.modeling102.repository.IdeaFileSerializer;
import main.modeling102.service.IdeaService;

/**
 * @author maruf
 * @since 10/26/17
 */
public class IdeaServiceSerializerImpl implements IdeaService {
    private static final IdeaService ideaService = new IdeaServiceSerializerImpl();
    private final IdeaFileSerializer ideaFileSerializer;

    private IdeaServiceSerializerImpl() {
        this.ideaFileSerializer = IdeaFileSerializer.get();
    }

    public static IdeaService getInstance() {
        return ideaService;
    }

}
