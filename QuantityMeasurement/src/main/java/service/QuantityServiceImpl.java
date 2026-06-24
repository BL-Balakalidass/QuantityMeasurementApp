package main.java.service;

import main.java.IMeasurable;
import main.java.Quantity;
import main.java.entity.QuantityEntity;

public class QuantityServiceImpl implements QuantityService {

    @Override
    public <U extends Enum<U> & IMeasurable>
    QuantityEntity<U> add(QuantityEntity<U> request) {

        try {

            Quantity<U> result;

            if (request.getTargetUnit() == null) {
                result = request.getFirstQuantity()
                        .add(request.getSecondQuantity());
            } else {
                result = request.getFirstQuantity()
                        .add(
                                request.getSecondQuantity(),
                                request.getTargetUnit());
            }

            return new QuantityEntity<>(result);

        } catch (Exception exception) {

            return new QuantityEntity<>(
                    exception.getMessage());
        }
    }

    @Override
    public <U extends Enum<U> & IMeasurable>
    QuantityEntity<U> subtract(QuantityEntity<U> request) {

        try {

            Quantity<U> result;

            if (request.getTargetUnit() == null) {
                result = request.getFirstQuantity()
                        .subtract(request.getSecondQuantity());
            } else {
                result = request.getFirstQuantity()
                        .subtract(
                                request.getSecondQuantity(),
                                request.getTargetUnit());
            }

            return new QuantityEntity<>(result);

        } catch (Exception exception) {

            return new QuantityEntity<>(
                    exception.getMessage());
        }
    }

    @Override
    public <U extends Enum<U> & IMeasurable>
    QuantityEntity<U> divide(QuantityEntity<U> request) {

        try {

            double result =
                    request.getFirstQuantity()
                            .divide(request.getSecondQuantity());

            return new QuantityEntity<>(result);

        } catch (Exception exception) {

            return new QuantityEntity<>(
                    exception.getMessage());
        }
    }

    @Override
    public <U extends Enum<U> & IMeasurable>
    QuantityEntity<U> convert(QuantityEntity<U> request) {

        try {

            Quantity<U> result =
                    request.getFirstQuantity()
                            .convertTo(request.getTargetUnit());

            return new QuantityEntity<>(result);

        } catch (Exception exception) {

            return new QuantityEntity<>(
                    exception.getMessage());
        }
    }

    @Override
    public <U extends Enum<U> & IMeasurable>
    QuantityEntity<U> compare(QuantityEntity<U> request) {

        try {

            boolean result =
                    request.getFirstQuantity()
                            .equals(request.getSecondQuantity());

            return new QuantityEntity<>(result);

        } catch (Exception exception) {

            return new QuantityEntity<>(
                    exception.getMessage());
        }
    }
}