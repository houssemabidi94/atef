import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RhprofileComponent } from './rhprofile.component';

describe('RhprofileComponent', () => {
  let component: RhprofileComponent;
  let fixture: ComponentFixture<RhprofileComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RhprofileComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RhprofileComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
