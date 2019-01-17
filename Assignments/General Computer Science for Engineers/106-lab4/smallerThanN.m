function [ newVector ] = smallerThanN( vector, n )
% Returns a list of values from vector
% that are less than n
    newVector = [];
    for i = 1:length(vector)
        elem = vector(i);
        if (elem < n)
            newVector = [newVector elem];
        end
    end
end

