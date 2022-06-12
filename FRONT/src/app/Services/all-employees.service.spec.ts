import { TestBed } from '@angular/core/testing';

import { AllEmployeesService } from './all-employees.service';

describe('AllEmployeesService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: AllEmployeesService = TestBed.get(AllEmployeesService);
    expect(service).toBeTruthy();
  });
});
